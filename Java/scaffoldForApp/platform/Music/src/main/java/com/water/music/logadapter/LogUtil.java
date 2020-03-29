package com.water.music.logadapter;


import com.water.music.logadapter.factory.LoggerFactory;
import com.water.music.logadapter.factory.LoggerFactoryForLog4j2;
import com.water.music.logadapter.factory.LoggerFactoryForSLF4J;
import com.water.music.logadapter.model.Logger;

/**
 * log tools , single instance class , provide log object to client
 * the object return by this class is custom log , log provide common format of each log
 */
public class LogUtil {

    private static LoggerFactory loggerFactory;

    /**
     * when application init must invoke once
     * @param logFrame
     */
    public static void useFrame(String logFrame){
        if (loggerFactory == null){
            if(logFrame.equalsIgnoreCase("LOG4J2")){
                loggerFactory  =  new LoggerFactoryForLog4j2();
            }else if(logFrame.equalsIgnoreCase("SLF4J")){
                loggerFactory = new LoggerFactoryForSLF4J();
            }
        }

    }

    public Logger getDebugLogger(Class<?> clazz){
         return loggerFactory.getDebugLogger(clazz);
    }

    public  Logger getRuntimeLogger(){
        return null;
    }

    public  Logger getOperateLogger(){
        return null;
    }

    public  Logger getTraceLogger(){
        return null;
    }

    public  Logger getBusinessLogger(){
        return null;
    }

    public  Logger getServiceRejectLogger(){
        return null;
    }
}
