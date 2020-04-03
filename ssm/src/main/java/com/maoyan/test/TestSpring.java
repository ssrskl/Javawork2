package com.maoyan.test;

import com.maoyan.service.AccountService;
import com.maoyan.service.impl.AccountServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Maoyan
 * @data 2020/4/2 16:02
 * @Version 1.0.0
 */
public class TestSpring {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        AccountService accountService = (AccountService) applicationContext.getBean("service");
        accountService.findAll();
    }
}
