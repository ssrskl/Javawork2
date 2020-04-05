package com.maoyan;

import com.maoyan.pojo.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Maoyan
 * @data 2020/4/4 11:40
 * @Version 1.0.0
 */
public class test {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        User user = (User) ac.getBean("peo");
        System.out.println(user);
    }


}
