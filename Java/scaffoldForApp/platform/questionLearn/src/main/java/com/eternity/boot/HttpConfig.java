package com.eternity.boot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * http server config
 */
@Component
public
class HttpConfig {

    /**
     * http server listen port
     */
    @Value("${http.server.listen.port}")
    private int listenPort;

    public
    int getListenPort() {
        return listenPort;
    }

    public
    void setListenPort(int listenPort) {
        this.listenPort = listenPort;
    }
}

