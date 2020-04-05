package com.maoyan.service.impl;

import com.maoyan.pojo.User;
import com.maoyan.service.TestService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Maoyan
 * @data 2020/4/4 11:32
 * @Version 1.0.0
 */
public class TestServiceimpl implements TestService {
    @Override
    public void Test() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        User user = (User) applicationContext.getBean("userclass");
        System.out.println("测试spring"+user);
    }
}
