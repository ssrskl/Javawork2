package com.maoyan.test;

import com.maoyan.dao.impl.SpringZhuimpl;
import javafx.application.Application;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Maoyan
 * @data 2020/3/28 13:32
 * @Version 1.0.0
 */
public class Test {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        SpringZhuimpl springZhuimpl = (SpringZhuimpl) applicationContext.getBean("zhutest");
        System.out.println(springZhuimpl);
    }
}
