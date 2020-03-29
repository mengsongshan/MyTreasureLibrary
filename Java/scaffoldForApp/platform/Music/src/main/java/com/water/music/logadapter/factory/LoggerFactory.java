package com.water.music.logadapter.factory;

import com.water.music.logadapter.model.Logger;

public
interface LoggerFactory {

    Logger getLogger(String logType, Class<?> name);

    Logger getDebugLogger(Class<?> name);

    Logger getOperateLogger(Class<?> name);

    Logger getAlarmLogger(Class<?> name);
}
