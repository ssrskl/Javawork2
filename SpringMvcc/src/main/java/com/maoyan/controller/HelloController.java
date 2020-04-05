package com.maoyan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Maoyan
 * @data 2020/4/2 20:35
 * @Version 1.0.0
 */
@Controller
@RequestMapping(path = "/remapping")
public class HelloController {

    @RequestMapping(path = "/hello")
    public String sayHello(){
        System.out.println("hello springmvc!");
        return "success";
    }

    @RequestMapping(path = "/mappingTest",method = {RequestMethod.GET},
            params = "user=maoyan",headers = "Accept")
    public String mappingTest(){
        System.out.println("测试注解");
        return "success";
    }
}
