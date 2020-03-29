package com.eternity.boot;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.PooledByteBufAllocator;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpRequestDecoder;
import io.netty.handler.codec.http.HttpResponseEncoder;
import io.netty.handler.stream.ChunkedWriteHandler;

/**
 * 创建一个简单的HttpServer用于心跳测试，检测服务是否正常。
 */
public
class HttpServer {

    public void bind(int listenPort, HttpHandler handler){
        NioEventLoopGroup bossGroup = new NioEventLoopGroup();
        NioEventLoopGroup workerGroup = new NioEventLoopGroup();

        ServerBootstrap server = new ServerBootstrap();
        server.group(bossGroup, workerGroup).
                channel(NioServerSocketChannel.class).
                option(ChannelOption.SO_BACKLOG, 1024).
                option(ChannelOption.SO_KEEPALIVE, false).
                option(ChannelOption.SO_REUSEADDR, true).
                option(ChannelOption.SO_RCVBUF, 65535).
                option(ChannelOption.SO_SNDBUF, 65535).
                option(ChannelOption.TCP_NODELAY, true).
                childHandler(new ChildChannelHandler(handler));

        try {
            server.childOption(ChannelOption.ALLOCATOR, PooledByteBufAllocator.DEFAULT);
            ChannelFuture f = server.bind(listenPort).sync();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }

    }

    private class ChildChannelHandler extends ChannelInitializer {
        private HttpHandler handler;

        ChildChannelHandler(HttpHandler handler){
            this.handler = handler;
        }

        @Override
        protected
        void initChannel(Channel channel) throws Exception {
                channel.pipeline().
                        addLast(new HttpRequestDecoder()).
                        addLast(new HttpObjectAggregator(65535)).
                        addLast(new HttpResponseEncoder()).
                        addLast(new ChunkedWriteHandler()).
                        addLast(handler);
        }
    }

}
