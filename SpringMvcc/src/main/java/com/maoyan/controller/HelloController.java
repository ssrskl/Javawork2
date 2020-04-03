package com.maoyan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Maoyan
 * @data 2020/4/2 20:35
 * @Version 1.0.0
 */
@Controller
public class HelloController {

    @RequestMapping(path = "/hello")
    public String sayHello(){
        System.out.println("hello springmvc!");
        return "success";
    }
}
