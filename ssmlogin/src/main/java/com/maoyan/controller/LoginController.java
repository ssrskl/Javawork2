package com.maoyan.controller;

import com.maoyan.pojo.User;
import com.maoyan.service.LoginService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Maoyan
 * @data 2020/4/4 11:51
 * @Version 1.0.0
 */
@Controller
@RequestMapping("/main")
public class LoginController {

    @RequestMapping(path = "/login",method = RequestMethod.POST)
    public String login(User user){
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        LoginService loginServiceimpl = (LoginService) ac.getBean("loginServiceimpl");

        return "success";
    }
}
