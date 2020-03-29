package com.water.music.concurrent;

import com.water.music.concurrent.threadpool.ThreadPool;
import com.water.music.util.ResourceUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.*;

public class ThreadPoolUtil {
    private static Logger logger = LoggerFactory.getLogger(ThreadPoolUtil.class);
    private static Properties poolConfig = new Properties();
    private static Map<String,ThreadPool> threadPools = new ConcurrentHashMap<String,ThreadPool>();

    private ThreadPoolUtil(){

    }
    private static ThreadPool configThreadPool(String configFileName){
        InputStream config = ResourceUtil.getClasspathFile(configFileName);
        if(config == null){
            config = ResourceUtil.getClasspathFile("defaultThreadPoolConfig.properties");
            try {
                poolConfig.load(config);
                ThreadPoolExecutor tpe = new ThreadPoolExecutor(4,10,1000, TimeUnit.SECONDS,new ArrayBlockingQueue(10000));
            } catch (IOException e) {
                logger.error("fail load thread pool config ");
            }
        }else {

        }
        return null;
    }


    public static ExecutorService getPool(int threadNum){
        ExecutorService pool = Executors.newFixedThreadPool(threadNum);
        return pool;
    }

    /**
     *  base config file build named thread pool
     * @param threadPoolName
     * @param configFileName
     * @return
     */
    public static synchronized ThreadPool getNamedThreadPool(String threadPoolName, String configFileName){
        ThreadPool tp = threadPools.get(threadPoolName);
        if(tp != null){
            return tp;
        }else{
           tp = configThreadPool(configFileName);
           threadPools.put(threadPoolName,tp);
        }
        return tp;
    }

    /**
     * shut down named thread pool when task execute complete
     * @param threadPoolName
     */
    public static void shutDownNamedThreadPool(String threadPoolName){

    }

    /**
     * immediately shut down named thread pool
     * @param threadPoolName
     */
    public static void immediateShutDownNamedThreadPool(String threadPoolName){

    }

    /**
     * destory thread pool
     */
    public static void destoryThreadPool(){

    }

    public String getStatistics(){

        return null;

    }
}
