package com.maoyan.controller;

import com.maoyan.pojo.User;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author Maoyan
 * @data 2020/4/3 10:46
 * @Version 1.0.0
 */
@Controller
@RequestMapping("/param")
public class ParamController {

    @RequestMapping("/testParam")
    //参数与jsp传的参数相同，MVC会自动的给参数赋值
    public String testParam(String username){
        System.out.println("testParam执行了,参数为："+username);
        return "success";
    }

    @RequestMapping(path = "/saveUser",method = RequestMethod.POST)
    public String saveUser(User user, HttpServletRequest request, HttpServletResponse response){
        //会自动的封装到Uesr中
        System.out.println("用户名："+user.getUsername());
        System.out.println("密码："+user.getPassword());
        System.out.println("女朋友的名字："+user.getGirlFriend().getName());
        System.out.println("女朋友的年龄"+user.getGirlFriend().getAge());
        System.out.println("生日为："+user.getDate());
        //获取原生的API
        System.out.println(request.getParameter("username"));
        System.out.println(request.getParameter("password"));
        HttpSession session = request.getSession();
        session.setAttribute("username",user.getUsername());
        System.out.println(session.getId());
        System.out.println(session.getAttribute("username"));
        return "success";
    }

}
