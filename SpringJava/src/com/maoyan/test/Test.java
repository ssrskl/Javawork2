package com.maoyan.test;

import com.maoyan.pojo.People;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Maoyan
 * @date 2020/3/26 19:55
 */
public class Test {
    public static void main(String[] args){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Spring4.xml");
        People people = applicationContext.getBean("peo",People.class);
        System.out.println(people);
        System.out.println(people.getAge());
        System.out.println(people.getName());
    }
}
