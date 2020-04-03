package com.bjsxt.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Service方法和doGet方法和doPost方法的区别
 * 	Service方法：
 * 		可以处理get/post方式的请求，如果servlet中有Service方法，会优先调用service方法对请求进行处理。
 * 	doGet方法：
 * 		处理get方式的请求
 * 	doPost方法：
 * 		处理post方式的请求
 * 注意：
 * 		如果在覆写的service方法中调用了父类的service方法(super.service(arg0, arg1)),
 * 		则service方法处理完后，会再次根据请求方式响应的doGet和doPost方法执行。所以，一般情况下
 * 		我们是不在覆写的service中调用父类的service方法的，避免出现405错误。
 * Servlet的常见错误：
 * 		404错误:资源未找到
 * 			原因一：在请求地址中的servlet的别名书写错误。
 * 			原因二：虚拟项目名称拼写错误
 *		500错误：内部服务器错误
 *			错误一：
 *				java.lang.ClassNotFoundException: com.bjsxt.servlet.ServletMothod
 * 				解决：
 * 					在web.xml中校验servlet类的全限定路径是否拼写错误。
 *			错误二：
 *				因为service方法体的代码执行错误导致
 *				解决：
 *					根据错误提示对service方法体中的代码进行错误更改。
 *		405错误:请求方式不支持
 *			原因：
 *				请求方式和servlet中的方法不匹配所造成的。
 *			解决：
 *				尽量使用service方法进行请求处理，并且不要再service方法中调用父类的service。
 * @author MyPC
 */
public class ServletMethod extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		int i=5/0;
		System.out.println("我是service");
		super.service(req, resp);
		
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("我是doGet方法");
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("我是doPost方法");
	}	
}
