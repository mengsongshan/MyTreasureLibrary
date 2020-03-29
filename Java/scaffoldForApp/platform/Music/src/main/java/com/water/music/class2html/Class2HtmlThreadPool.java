package com.water.music.class2html;

import com.water.music.concurrent.task.Task;
import com.water.music.concurrent.ThreadPoolUtil;

import java.util.concurrent.ExecutorService;

public class Class2HtmlThreadPool {

    public static ExecutorService pool = ThreadPoolUtil.getPool(5);

    public static void execute(Task task){
        pool.execute(task);
    }


}
