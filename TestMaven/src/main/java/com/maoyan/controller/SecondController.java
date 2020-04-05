package com.maoyan.controller;

import com.maoyan.mapper.UserMapper;
import com.maoyan.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author Maoyan
 * @data 2020/4/5 19:33
 * @Version 1.0.0
 */
@Controller
@RequestMapping("second")
@ConfigurationProperties(prefix = "person")
public class SecondController {
    private String name;
    private Integer age;

    @RequestMapping("/quick")
    @ResponseBody
    public String quick(){
        return "springboot 访问成功! name="+name+",age="+age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

}
