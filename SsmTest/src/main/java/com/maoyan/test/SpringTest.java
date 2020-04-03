package com.maoyan.test;

import com.maoyan.service.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Maoyan
 * @data 2020/4/2 15:25
 * @Version 1.0.0
 */
public class SpringTest {
    //单元测试
    @Test
    public void run1(){
        //加载配置文件
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        //获取对象
        AccountService accountService = (AccountService) applicationContext.getBean("accountService");
        //调用方法
        accountService.findAll();
    }
}
