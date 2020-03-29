package com.water.music.logadapter.factory;

import com.water.music.logadapter.model.TargetLog4jLogger;
import com.water.music.logadapter.model.TargetLogger;
import org.apache.logging.log4j.LogManager;

public final
class LoggerFactoryForLog4j2 extends AbstractLoggerFactory {

    TargetLogger getLogTarget(Class<?> name){
        TargetLogger targetLogger = new TargetLog4jLogger(LogManager.getLogger(name));
        return targetLogger;
    }


}
