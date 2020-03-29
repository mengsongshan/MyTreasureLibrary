package com.water.music.core;

import org.apache.logging.log4j.Logger;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;

/**
 *  服务分发器，本组件具备服务分发能力，服务追踪能力，接口流控能力，恶意调用屏蔽能力，接口性能统计能力，接口放通能力。
 *
 */
public class MessageRouter extends GenericServlet {

    private String interfaceName ;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        // one user request time

        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        setInterfaceName(req);

        // record request content and return , application  large load
        interfaceThrough(req);

        // filter login interface
        interfaceNeedLogin(req);


        try {
            // start flow

            // dispatch service
            dispatch(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //end flow

            // one user request time

        }

    }



    private void flowControl(String interfaceName){

    }
    /**
     * some interface need login
     * list interface names for login
     * @param req
     */
    private void interfaceNeedLogin(HttpServletRequest req){
        String interfaceName = req.getPathInfo();
        HttpSession session = req.getSession();

    }

    /**
     * service dispatch
     * @param req
     * @param resp
     */
    private void dispatch(HttpServletRequest req, HttpServletResponse resp){

    }

    /**
     * interface through when load to large
     * async record request content , socket client send request to back host ,
     * most use in not real time interface , utmost reduce influence
     * precondition ensure transaction integrity
     * @param req
     */
    private void interfaceThrough(HttpServletRequest req){

    }

    private void setInterfaceName(HttpServletRequest req){
        String path = req.getPathInfo();
        interfaceName = path;
    }
}
