package com.water.music.logadapter.factory;


import com.water.music.logadapter.model.TargetLogger;
import com.water.music.logadapter.model.TargetSLF4jLogger;

public final
class LoggerFactoryForSLF4J extends AbstractLoggerFactory {

     TargetLogger getLogTarget(Class<?> name){
         TargetLogger targetLogger = new TargetSLF4jLogger(org.slf4j.LoggerFactory.getLogger(name));

        return targetLogger;
    }

}
