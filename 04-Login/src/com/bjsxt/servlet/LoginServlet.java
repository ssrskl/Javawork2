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
 * ��������������:
 * 	1��ʹ��String�����������±���
 * 			uname=new String(uname.getBytes("iso8859-1"),"utf-8");
 *  2��ʹ�ù�������
 * 		get��ʽ��
 * 			����һ��req.setCharacterEncoding("utf-8");
 * 			�������
 * 				��tomcat��Ŀ¼�µ�confĿ¼���޸�server.xml�ļ�����Connector��ǩ���������� useBodyEncodingForURI="true"
 * 		post��ʽ��
 * 			req.setCharacterEncoding("utf-8");
 * Servlet�����ܽ�:
 * 		������������󵽷�����(����)
 *      ��������������������󣬽��н���������request����洢��������
 *      ���������ö�Ӧ��servlet��������������request������Ϊʵ�δ��ݸ�servlet�ķ���
 *      servlet�ķ���ִ�н���������
 *      		//������������ʽ
 *      		//������Ӧ�����ʽ
 *      		//��ȡ������Ϣ
 *      		//����������Ϣ
 *      			//����ҵ������
 *      			//����ҵ������ķ���
 *      		//��Ӧ������
 *����ת��ѧϰ��
 *		����:ʵ�ֶ��servlet������������������������������࣬��servlet��ְ�������ȷ��
 *		ʹ�ã�
 *				req.getRequestDispatcher("Ҫת���ĵ�ַ").forward(req, resp);
 *				��ַ�����·����ֱ����дservlet�ı������ɡ�
 *		�ص�:
 *			һ�������������ַ����Ϣ���ı䡣
 *		ע�⣺
 *			����ת����ֱ��return�������ɡ�
 *reuqet������
 *		�����һ�������ڵ�servlet�����ݹ�������
 *�ض���
 *		����˱��ظ��ύ�����⣬�Լ���ǰservlet�޷��������������⡣
 *		ʹ��:
 *			resp.sendRedirect(String uri);
 *		ʾ��:
 *			resp.sendRedirect("/login/main");
 *		�ص㣺
 *			������������request����
 *			�������ַ����Ϣ�ı�
 *		ʱ����
 *			����������б����ݣ��������ֱȽ���Ҫ�������ظ��ύ������ʹ���ض���
 *			�������Servlet���պ��޷����д�������ʹ���ض���λ�����Դ������Դ��	
 *
 * @author MyPC
 */
public class LoginServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//������������ʽ:
			req.setCharacterEncoding("utf-8");
		//������Ӧ�����ʽ
			resp.setContentType("text/html;charset=utf-8");
		//��ȡ������Ϣ
			String uname=req.getParameter("uname");
			//uname=new String(uname.getBytes("iso8859-1"),"utf-8");//ʹ��String�����������±���
			String pwd=req.getParameter("pwd");
			System.out.println(uname+":"+pwd);
		//����������Ϣ
			//��ȡҵ������
			LoginService ls=new LoginServiceImpl();
			User u=ls.checkLoginService(uname, pwd);
			System.out.println(u);
		//��Ӧ������
			if(u!=null){
				//����Cookie��Ϣʵ���������¼��
					Cookie c=new Cookie("uid", u.getUid()+"");
					//����Cookie����Ч��
					c.setMaxAge(3*24*3600);
					c.setPath("/login/ck");
					//���Cookie��Ϣ
					resp.addCookie(c);
				//����ת��
					//req.getRequestDispatcher("main").forward(req, resp);
				//�ض���
				resp.sendRedirect("/login/main");
				return;
			}else{
				//ʹ��request����ʵ�ֲ�ͬServlet��������ת
				req.setAttribute("str", "�û������������");
				//ʹ������ת��
				req.getRequestDispatcher("page").forward(req, resp);
				return;
			}
	}
}
