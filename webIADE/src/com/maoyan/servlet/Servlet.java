package com.maoyan.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

//@WebServlet(name = "Servlet")
public class Servlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        //初始化方法，会在Servlet第一次加载储存时执行
        System.out.println("初始化完成！！");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write("servlet life");
        resp.setHeader("Tom","Cat");



        System.out.println("servlet life");
        String UserAgent = req.getHeader("User-Agent");
        System.out.println(UserAgent);
        //获取所有的用户请求数据的键的枚举集合---req.getParameterNames()
        //Enumeration枚举类型
        Enumeration enumeration = req.getHeaderNames();
        while (enumeration.hasMoreElements()){
            String name = (String) enumeration.nextElement();
            String value = req.getHeader(name);
            System.out.println(name+": "+value);
        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String usernamee = request.getParameter("username");
        String password = request.getParameter("password");
        if (usernamee.equals("张三")&&password.equals("123")){
            System.out.println("SUCCESS");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    public void destroy() {
        System.out.println("Servlet被销毁");
    }
}
