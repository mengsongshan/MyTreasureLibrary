package com.water.music.concurrent.task;

import java.util.HashMap;
import java.util.Map;

public abstract class LongTimeTask implements Task {

    private long runTime ;
    private String taskName;
    private Map<String,String> statistics = new HashMap<String,String>();
    private TaskContext tc;

    public LongTimeTask(String taskName){
        this.taskName = taskName;
    }

    public LongTimeTask(String taskName, TaskContext tc){
        this.taskName = taskName;
        this.tc = tc;
    }

    public void run()
    {
        long start = System.currentTimeMillis();
        beforeTask();
        task();
        afterTask();
        runTime = System.currentTimeMillis() - start;
    }

    public abstract void task();
    public abstract void beforeTask();
    public abstract void afterTask();

    public Map<String, String> getStatistics() {
        statistics.put("RunTime",runTime+"ms");
        statistics.put("TaskName",taskName);
        return statistics;
    }
}
