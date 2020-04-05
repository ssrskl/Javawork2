package com.maoyan.controller;

import com.maoyan.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Maoyan
 * @data 2020/4/3 20:40
 * @Version 1.0.0
 */
@Controller
@RequestMapping("/main")
public class MainController {

    @RequestMapping("/test")
    public String test(Model model){
        System.out.println("执行成功");
        User user = new User();
        user.setUsername("maoyan");
        user.setPassword("123");
        //model对象
        model.addAttribute("user",user);
        return "success";
    }

    @RequestMapping("/testModelandView")
    public ModelAndView testModelandView(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("username","maoyan");
        //跳转到哪个页面
        modelAndView.setViewName("success");
        return modelAndView;
    }

    @RequestMapping("/testAjax")
    public @ResponseBody User testAjax(@RequestBody User user){
        System.out.println("方法执行了");
        System.out.println(user);
        return user;
    }
}
