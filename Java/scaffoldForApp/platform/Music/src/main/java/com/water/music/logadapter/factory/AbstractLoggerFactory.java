package com.water.music.logadapter.factory;


import com.water.music.logadapter.model.*;

public abstract
class AbstractLoggerFactory implements LoggerFactory{

    abstract
    TargetLogger getLogTarget(Class<?> name);

    @Override
    public
    Logger getLogger(String logType, Class<?> name) {
        return null;
    }

    @Override
    public
    Logger getDebugLogger(Class<?> name) {
        Logger logger = new DebugLogger(getLogTarget(name));
        return logger;
    }

    @Override
    public
    Logger getOperateLogger(Class<?> name) {
        Logger logger = new OperateLogger(getLogTarget(name));
        return logger;
    }

    @Override
    public
    Logger getAlarmLogger(Class<?> name) {
        Logger logger = new AlarmLogger(getLogTarget(name));
        return null;
    }

}
