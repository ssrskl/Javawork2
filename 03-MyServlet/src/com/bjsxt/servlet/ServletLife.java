package com.bjsxt.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet的生命周期：
 * 		1、从第一次调用到服务器关闭。
 * 		2、如果Servlet在web.xml中配置了load-on-startup，生命周期为从服务器启动到服务器关闭
 * 注意：
 * 		init方法是对Servlet进行初始化的一个方法，会在Servlet第一次加载进行存储时执行
 * 		destory方法是在servlet被销毁时执行，也就服务器关闭时。
 * @author MyPC
 *
 */
public class ServletLife extends HttpServlet {
	//初始化方法，在servlet第一次加载内容的时候被调用
	@Override
	public void init() throws ServletException {
		System.out.println("servlet初始化完成");
	}
	
	//service方法，真正处理请求的方法
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.getWriter().write("servlet life");
		System.out.println("servlet life");
	}
	@Override
	public void destroy() {
		System.out.println("我被销毁了...");
	}
	
	
}
