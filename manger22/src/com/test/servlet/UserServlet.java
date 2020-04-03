package com.test.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//设置请求编码格式
		req.setCharacterEncoding("utf-8");
		//设置响应编码格式
		resp.setContentType("text/html;charset=utf-8");
		//获取操作符
		String oper = req.getParameter("oper");
		if ("Login".equals(oper)) {
			//调用登录处理方法
			UserLogin(req,resp);
		}else if("Reg".equals(oper)){
			//调用注册方法
			//UserReg
		}else {
			System.out.println("没有找到"+oper);
		}
		
		
	}
	//处理登录
	private void UserLogin(HttpServletRequest req,HttpServletResponse resp) {
		//获取请求信息
		String uname = req.getParameter("uname");
		String pwd = req.getParameter("pwd");
		System.out.println(uname+";"+pwd);
				//处理请求信息
	}
}
