package com.water;

import com.eternity.services.users.bean.UserReq;
import com.eternity.services.users.UserProvider;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext-custom.xml");
        ac.start();
        UserProvider up = (UserProvider)ac.getBean("userService");
        UserReq  u = new UserReq();
        u.setAge("20");
        System.out.println(up.getUserInfoDetail(u));
    }
}
