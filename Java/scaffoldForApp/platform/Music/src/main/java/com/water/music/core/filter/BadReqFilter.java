package com.water.music.core.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * filter request , check request
 * 1.while list request
 * 2.request method check
 * 3.request content size check
 */

public class BadReqFilter implements Filter {
    private static final String METHOD_POST = "POST";
    private static final long REQ_MAX_SIZE = 1024*2;

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest r = (HttpServletRequest) req;
        HttpServletResponse p = (HttpServletResponse) resp;
        String method = r.getMethod();
        String host = r.getRemoteHost();

        whileListCheck(host);

        if( r.getContentLength() > REQ_MAX_SIZE ){
            p.sendError(401,"Bad request");
        }

        if(METHOD_POST.equals(method)){
            p.sendError(401,"Bad request");
        }

        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

    /**
     * client while list check
     * @param req
     */
    private void whileListCheck(String host){

    }
}
