package com.eternity.boot;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Dubbo微服务启动
 */
public
class DubboServiceStartup {

    public static
    void main(String[] args) {
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        ac.start();

        // 启动心跳检测
        new Thread(new Runnable() {
            @Override
            public
            void run() {
                    HttpConfig httpConfig = ac.getBean(HttpConfig.class);
                    HttpServer monitor = new HttpServer();
                    monitor.bind(httpConfig.getListenPort(), new HttpHandler());
            }
        }).start();
    }
}
