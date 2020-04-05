package com.maoyan.service.impl;

import com.maoyan.dao.LoginDao;
import com.maoyan.pojo.User;
import com.maoyan.service.LoginService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Maoyan
 * @data 2020/4/4 12:02
 * @Version 1.0.0
 */
public class LoginServiceImpl implements LoginService {

    ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
    @Override
    public User Login(String username, String password) {
        LoginDao logindao = (LoginDao) ac.getBean("logindao");
        return logindao.checkLoginDao(username,password);
    }
}
