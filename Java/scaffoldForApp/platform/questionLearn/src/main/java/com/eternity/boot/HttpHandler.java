package com.eternity.boot;

import com.alibaba.fastjson.JSON;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.*;
import io.netty.util.CharsetUtil;

import java.io.UnsupportedEncodingException;

/**
 * 客户端请求处理
 */
@ChannelHandler.Sharable
public
class HttpHandler extends SimpleChannelInboundHandler<FullHttpRequest> {

    @Override
    protected
    void channelRead0(ChannelHandlerContext channelHandlerContext, FullHttpRequest fullHttpRequest) throws Exception {

            // http 请求解析失败，返回错误信息
            if(fullHttpRequest.decoderResult().isFailure()){
                sendError(channelHandlerContext, HttpResponseStatus.BAD_REQUEST);
                return;
            }

        // dummy response
        FullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK);
        try {
            String uri = fullHttpRequest.uri();
            if (uri.equals("/health")) {
                writeResult(channelHandlerContext, fullHttpRequest, response, null);
                return;
            } else {
                response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.NOT_FOUND);
                writeResult(channelHandlerContext, fullHttpRequest, response, null);
                return;
            }
        } catch (Throwable e) {
            writeResult(channelHandlerContext, fullHttpRequest, response, null);
            return;
        }
    }

    private void sendError(ChannelHandlerContext channelHandlerContext, HttpResponseStatus status) {
        FullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, status,
                Unpooled.copiedBuffer(status.toString(), CharsetUtil.UTF_8));

        response.headers().set(HttpHeaderNames.CONTENT_TYPE, "text/plain; charset=UTF-8");
        channelHandlerContext.writeAndFlush(response).addListener(ChannelFutureListener.CLOSE);
    }

    /**
     * 向客户端写内容
     */
    private void writeResult(final ChannelHandlerContext channelHandlerContext, final FullHttpRequest req,
                             FullHttpResponse response, final Object data)  throws UnsupportedEncodingException {
        if (data != null) {
            String json = JSON.toJSONString(data);
            ByteBuf buf = Unpooled.copiedBuffer(json.getBytes("UTF-8"));
            response = response.replace(buf);
        }
        response.headers().set(HttpHeaderNames.CONTENT_TYPE, "application/json; charset=UTF-8");
        response.headers().set(HttpHeaderNames.CONTENT_LENGTH, response.content().readableBytes());

        channelHandlerContext.writeAndFlush(response).addListener(ChannelFutureListener.CLOSE);
    }

}
