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
		//������������ʽ
		req.setCharacterEncoding("utf-8");
		//������Ӧ�����ʽ
		resp.setContentType("text/html;charset=utf-8");
		//��ȡ������
		String oper = req.getParameter("oper");
		if ("Login".equals(oper)) {
			//���õ�¼������
			UserLogin(req,resp);
		}else if("Reg".equals(oper)){
			//����ע�᷽��
			//UserReg
		}else {
			System.out.println("û���ҵ�"+oper);
		}
		
		
	}
	//�����¼
	private void UserLogin(HttpServletRequest req,HttpServletResponse resp) {
		//��ȡ������Ϣ
		String uname = req.getParameter("uname");
		String pwd = req.getParameter("pwd");
		System.out.println(uname+";"+pwd);
				//����������Ϣ
	}
}
