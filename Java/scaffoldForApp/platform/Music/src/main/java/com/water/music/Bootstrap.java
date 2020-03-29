package com.water.music;


import com.water.music.concurrent.task.Task;
import com.water.music.controller.UserController;
import com.water.music.servicebean.user.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Bootstrap {

   public static void main(String[] args){
      oneConnectOneThread();
//      OneConnectMutilThread();
   }

   /**
    * one connect used by multiple thread
    * to understand one connect deal with to many sql request speed
    * one connect mapping multiple thread
    * one thread loop send sql to one connect
    */
   public static void OneConnectMutilThread(){
      ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
      UserController uc = (UserController)ac.getBean("userController");
      long beginTime = System.currentTimeMillis();
      Thread[] threads = new Thread[1000];
      for(int i=0 ; i < 1000;i++){
         threads[i] = new Thread(new Task() {
            @Override
            public
            void run() {
               uc.addUser(new User(1,"test1","男",18,"prefect"));
            }
         },"Thread-"+i);
         threads[i].start();
      }

      System.out.println("application end , use time\t" + (System.currentTimeMillis() - beginTime)+"ms");
      System.out.println(threads.length);
   }

   public static void oneConnectOneThread(){
      ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
      UserController uc = (UserController)ac.getBean("userController");
      long beginTime = System.currentTimeMillis();

      for(int i=0 ; i < 1000;i++){
         uc.addUser(new User(1+i,"test1","男",18,"prefect"));
      }

      System.out.println("application end , use time\t" + (System.currentTimeMillis() - beginTime)+"ms");

   }
}
