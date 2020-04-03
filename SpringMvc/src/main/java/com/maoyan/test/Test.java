package com.maoyan.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Maoyan
 * @data 2020/4/2 17:27
 * @Version 1.0.0
 */
@Controller
@RequestMapping("/happy")
public class Test {
    public String hello()
    {

        System.out.println("hello, springMVC!");
        return "success";
    }
}
