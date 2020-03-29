package com.water.music.logadapter.model;

import org.slf4j.Logger;

public
class TargetSLF4jLogger implements TargetLogger {
    private Logger logger;
    public TargetSLF4jLogger(Logger logger){
        this.logger = logger;
    }
}
