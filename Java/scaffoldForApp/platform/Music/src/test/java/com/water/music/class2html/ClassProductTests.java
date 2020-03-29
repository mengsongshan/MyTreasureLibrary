package com.water.music.class2html;

import com.water.music.concurrent.ThreadPoolUtil;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ClassProductTests {

    @Test
    public void testRun(){
         List<File> datas = new ArrayList<File>(5000);
         String[] rootPaths = new String[1];
         rootPaths[0] = "E:\\SoftwareForProgram\\alibaba-dubbo-dubbo-2.5.9-83-g0423219";
        /* ClassProduct cp = new ClassProduct(rootPaths,datas);
         cp.run();
         for(File f : datas){
             System.out.println(f.getName());
         }*/
    }

    @Test
    public void testCallalbeBetweenFuture(){
        ExecutorService es = ThreadPoolUtil.getPool(2);
//        FutrueDemo<String> fd = new FutrueDemo<String>();
        CallableDemo<String> cd = new CallableDemo<String>();
        Future<String>  result= es.submit(cd);
        try {
            System.out.println(result.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


    }

    class CallableDemo<String> implements Callable{
        private String test =null;
        @Override
        public String call() throws Exception {
            Thread.sleep(1000);
            System.out.println("-----callable-----");
            return test;
        }
    }

    class FutrueDemo<String> implements Future{
        private String test =null;
        @Override
        public
        boolean cancel(boolean mayInterruptIfRunning) {
            return false;
        }

        @Override
        public
        boolean isCancelled() {
            return false;
        }

        @Override
        public
        boolean isDone() {
            return false;
        }

        @Override
        public
        String get() throws InterruptedException, ExecutionException {
            Thread.sleep(1000*60*60);
            System.out.println("-----callable-----");
            return test;
        }

        @Override
        public
        Object get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
            return null;
        }
    }
}
