package com.bjsxt.servlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * request对象学习：
 * 		作用：request对象中封存了当前请求的所有请求信息
 * 		使用：
 * 			获取请求头数据
 * 					req.getMethod();//获取请求方式
 * 					req.getRequestURL();//获取请求URL信息
 * 					req.getRequestURI();//获取请求URI信息
 * 					req.getScheme();//获取协议
 * 			获取请求行数据
 * 					req.getHeader("键名");//返回指定的请求头信息
 * 					req.getHeaderNames();//返回请求头的键名的枚举集合
 * 			获取用户数据
 * 					req.getParameter("键名");//返回指定的用户数据
 * 					req.getParameterValues("键名");//返回同键不同值的请求数据(多选)，返回的数组。
 * 					req.getParameterNames()//返回所有用户请求数据的枚举集合
 * 			注意：
 * 				如果要获取的请求数据不存在，不会报错，返回null。
 * 
 * 		注意：
 * 			request对象由tomcat服务器创建，并作为实参传递给处理请求的servlet的service方法。
 * @author MyPC
 *
 */
public class RequestServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//获取请求头数据
				//获取请求方式
					String method = req.getMethod();
					System.out.println(method);
				//获取请求URL
					StringBuffer url=req.getRequestURL();
					System.out.println(url);
					//获取URI
					String uri=req.getRequestURI();
					System.out.println(uri);
				//获取协议
					String h=req.getScheme();
					System.out.println(h);
		//获取请求行数据
					//获取指定的请求行信息
					String value=req.getHeader("aaa");
					System.out.println(value);
					//获取所有的请求行的键的枚举
					Enumeration e = req.getHeaderNames();
					while(e.hasMoreElements()){
						String name=(String) e.nextElement();
						String value2=req.getHeader(name);
						System.out.println(name+":"+value2);
					}
		//获取用户数据
					String name=req.getParameter("uname");
					String pwd=req.getParameter("pwd");
					System.out.println(name+":"+pwd);
					//String fav=req.getParameter("fav");
					String[] favs=req.getParameterValues("fav");
					if(favs!=null){
						for(String fav:favs){
							System.out.println(fav);
						}
					}
					//获取所有的用户请求数据的键的枚举集合---req.getParameterNames()	
	}
}
