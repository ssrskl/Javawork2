package com.maoyan.test;

import com.maoyan.spring.People;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Maoyan
 * @date 2020/3/26 18:20
 */
public class Test {
    public static void main(String[] args){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("SpringPeizhi.xml");
        People people = applicationContext.getBean("peo",People.class);
        System.out.println(people);
    }
}
