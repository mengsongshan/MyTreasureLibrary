package com.water.music.class2html;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class TaskDispatch implements Runnable{

    public TaskDispatch(){

    }

    @Override
    public void run() {
        String[] paths = new String[1];
        paths[0] = "E:\\SoftwareForProgram\\alibaba-dubbo-dubbo-2.5.9-83-g0423219";
        Future<List<File>> result = Class2HtmlThreadPool.pool.submit(new ClassProduct(paths));
        try {
            List<File> files = result.get();
            for(File f : files){
                Class2HtmlThreadPool.execute(new SimpleClass2Html(f.getPath()));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        TaskDispatch td = new TaskDispatch();
        td.run();

    }

}
