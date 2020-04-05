package com.maoyan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

/**
 * @author Maoyan
 * @data 2020/4/3 15:54
 * @Version 1.0.0
 */
@Controller
@RequestMapping("/anno")
@SessionAttributes(value = "red")//把red=红色存到session中
public class AnnoController {

    @RequestMapping("/annoTest")
    public String annoTest(@RequestParam(name = "name") String username){
        System.out.println("annoTest执行成功"+username);
        return "success";
    }

    @RequestMapping(value = "/annoBody",method = RequestMethod.POST)
    public String annoBody(@RequestBody String body){
        System.out.println("获取请求体");
        System.out.println(body);
        return "success";
    }

    @RequestMapping("/annoSession")
    public String annoSession(Model model){
        System.out.println("向session域中保存数据");
        model.addAttribute("red","红色");
        return "success";
    }

    //获取session
    @RequestMapping("/getsession")
    public String annoGetSession(ModelMap modelMap){
        String red = (String) modelMap.get("red");
        System.out.println("session的值为："+red);
        return "success";
    }

    //清除session
    @RequestMapping("/delsession")
    public String delSession(SessionStatus sessionStatus){
        //此方法即为清除session
        sessionStatus.setComplete();
        return "success";
    }

    //优于其他方法先执行
    @ModelAttribute
    public void helloController(){
        System.out.println("hello AnnoContreller。。。。");
    }
}
