package com.maoyan;

import com.maoyan.dao.impl.SpringIoctestimpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Maoyan
 * @data 2020/3/28 10:35
 * @Version 1.0.0
 */
public class Test {
    public static void main(String[] args) {
        //根据配置文件，获取spring核心容器对象
       // ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        //根据id获取bean对象
        SpringIoctestimpl ioctestimpl = (SpringIoctestimpl) applicationContext.getBean("ioctest");
        SpringIoctestimpl ioctestimp2 = (SpringIoctestimpl) applicationContext.getBean("ioctest");

        //测试
        System.out.println(ioctestimpl);
        System.out.println(ioctestimp2);
        System.out.println(ioctestimp2==ioctestimpl);

        //手动关闭
        applicationContext.close();
    }
    @org.junit.Test
    public void run(){
        //根据配置文件，获取spring核心容器对象
        // ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        //根据id获取bean对象
        SpringIoctestimpl ioctestimpl = (SpringIoctestimpl) applicationContext.getBean("ioctest");
        SpringIoctestimpl ioctestimp2 = (SpringIoctestimpl) applicationContext.getBean("ioctest");

        //测试
        System.out.println(ioctestimpl);
        System.out.println(ioctestimp2);
        System.out.println(ioctestimp2==ioctestimpl);

        //手动关闭
        applicationContext.close();
    }
}
