package com.bjsxt.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bjsxt.pojo.User;
import com.bjsxt.service.LoginService;
import com.bjsxt.service.impl.LoginServiceImpl;
/**
 * 请求中文乱码解决:
 * 	1、使用String进行数据重新编码
 * 			uname=new String(uname.getBytes("iso8859-1"),"utf-8");
 *  2、使用公共配置
 * 		get方式：
 * 			步骤一：req.setCharacterEncoding("utf-8");
 * 			步骤二：
 * 				在tomcat的目录下的conf目录中修改server.xml文件：在Connector标签中增加属性 useBodyEncodingForURI="true"
 * 		post方式：
 * 			req.setCharacterEncoding("utf-8");
 * Servlet流程总结:
 * 		浏览器发起请求到服务器(请求)
 *      服务器接受浏览器的请求，进行解析，创建request对象存储请求数据
 *      服务器调用对应的servlet进行请求处理，并将request对象作为实参传递给servlet的方法
 *      servlet的方法执行进行请求处理
 *      		//设置请求编码格式
 *      		//设置响应编码格式
 *      		//获取请求信息
 *      		//处理请求信息
 *      			//创建业务层对象
 *      			//调用业务层对象的方法
 *      		//响应处理结果
 *请求转发学习：
 *		作用:实现多个servlet联动操作处理请求，这样避免代码冗余，让servlet的职责更加明确。
 *		使用：
 *				req.getRequestDispatcher("要转发的地址").forward(req, resp);
 *				地址：相对路径，直接书写servlet的别名即可。
 *		特点:
 *			一次请求，浏览器地址栏信息不改变。
 *		注意：
 *			请求转发后直接return结束即可。
 *reuqet作用域：
 *		解决了一次请求内的servlet的数据共享问题
 *重定向：
 *		解决了表单重复提交的问题，以及当前servlet无法处理的请求的问题。
 *		使用:
 *			resp.sendRedirect(String uri);
 *		示例:
 *			resp.sendRedirect("/login/main");
 *		特点：
 *			两次请求，两个request对象。
 *			浏览器地址栏信息改变
 *		时机：
 *			如果请求中有表单数据，而数据又比较重要，不能重复提交，建议使用重定向。
 *			如果请求被Servlet接收后，无法进行处理，建议使用重定向定位到可以处理的资源。	
 *
 * @author MyPC
 */
public class LoginServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//设置请求编码格式:
			req.setCharacterEncoding("utf-8");
		//设置响应编码格式
			resp.setContentType("text/html;charset=utf-8");
		//获取请求信息
			String uname=req.getParameter("uname");
			//uname=new String(uname.getBytes("iso8859-1"),"utf-8");//使用String进行数据重新编码
			String pwd=req.getParameter("pwd");
			System.out.println(uname+":"+pwd);
		//处理请求信息
			//获取业务层对象
			LoginService ls=new LoginServiceImpl();
			User u=ls.checkLoginService(uname, pwd);
			System.out.println(u);
		//响应处理结果
			if(u!=null){
				//创建Cookie信息实现三天免登录。
					Cookie c=new Cookie("uid", u.getUid()+"");
					//设置Cookie的有效期
					c.setMaxAge(3*24*3600);
					c.setPath("/login/ck");
					//添加Cookie信息
					resp.addCookie(c);
				//请求转发
					//req.getRequestDispatcher("main").forward(req, resp);
				//重定向
				resp.sendRedirect("/login/main");
				return;
			}else{
				//使用request对象实现不同Servlet的数据流转
				req.setAttribute("str", "用户名或密码错误");
				//使用请求转发
				req.getRequestDispatcher("page").forward(req, resp);
				return;
			}
	}
}
