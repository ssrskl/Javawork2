package com.maoyan.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Maoyan
 * @data 2020/4/5 18:55
 * @Version 1.0.0
 */
@Controller
@RequestMapping("/main")
public class MainController {

    @Value("${person.name}")
    private String name;
    @Value("${person.age}")
    private Integer age;
    @RequestMapping("/quick")
    @ResponseBody
    public String quick(){
        System.out.println("springboot success");
        return "名字"+name+"年龄"+age;
    }

}
