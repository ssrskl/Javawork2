package com.bjsxt.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet���������ڣ�
 * 		1���ӵ�һ�ε��õ��������رա�
 * 		2�����Servlet��web.xml��������load-on-startup����������Ϊ�ӷ������������������ر�
 * ע�⣺
 * 		init�����Ƕ�Servlet���г�ʼ����һ������������Servlet��һ�μ��ؽ��д洢ʱִ��
 * 		destory��������servlet������ʱִ�У�Ҳ�ͷ������ر�ʱ��
 * @author MyPC
 *
 */
public class ServletLife extends HttpServlet {
	//��ʼ����������servlet��һ�μ������ݵ�ʱ�򱻵���
	@Override
	public void init() throws ServletException {
		System.out.println("servlet��ʼ�����");
	}
	
	//service������������������ķ���
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.getWriter().write("servlet life");
		System.out.println("servlet life");
	}
	@Override
	public void destroy() {
		System.out.println("�ұ�������...");
	}
	
	
}
