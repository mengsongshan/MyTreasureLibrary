package com.water.music.logadapter.model;

import org.apache.logging.log4j.Logger;
public
class TargetLog4jLogger implements TargetLogger {
    private Logger logger;
    public TargetLog4jLogger(Logger logger){
        this.logger = logger;
    }
}
