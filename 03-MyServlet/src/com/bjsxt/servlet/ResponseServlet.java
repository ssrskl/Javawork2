package com.bjsxt.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Respone对象学习：
 * 		作用：
 * 			用来响应数据到浏览器的一个对象
 * 		使用：
 * 			设置响应头
 * 				setHeader(String name,String value);//在响应头中添加响应信息，但是同键会覆盖
 * 				addHeader(String name,String value);//在响应头中添加响应信息，但是不会覆盖。
 * 			设置响应状态
 * 				sendError(int num,String msg);//自定义响应状态码。
 * 			设置响应实体
 * 				resp.getWrite().write(String str);//响应具体的数据给浏览器
 * 		设置响应编码格式：
 * 				resp.setContentType("text/html;charset=utf-8");
 * 		总结：
 * 			service请求处理代码流程：
 * 				设置响应编码格式
 * 				获取请求数据
 * 				处理请求数据
 * 					数据库操作（MVC思想）	
 * 				响应处理结果
 * @author MyPC
 *
 */


public class ResponseServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
			//获取请求信息
				//获取请求头
				//获取请求行
				//获取用户数据
			//处理请求
				
			//响应处理结果
				//设置响应头
				resp.setHeader("mouse", "two fly birds");
				resp.setHeader("mouse", "bjsxt");
				resp.addHeader("key", "thinkpad");
				resp.addHeader("key", "wollo");
				//设置响应编码格式
					//resp.setHeader("content-type", "text/html;charset=utf-8");
					//resp.setContentType("text/plain;charset=utf-8");
					//resp.setContentType("text/xml;charset=utf-8");
					resp.setContentType("text/html;charset=utf-8");
				//设置响应状态吗
					//resp.sendError(404, "this Method is not supported");
				//设置响应实体
					resp.getWriter().write("<b>今天天气真好，适合学习</b>");
				
				
	}
}
