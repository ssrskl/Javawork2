package com.bjsxt.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Respone����ѧϰ��
 * 		���ã�
 * 			������Ӧ���ݵ��������һ������
 * 		ʹ�ã�
 * 			������Ӧͷ
 * 				setHeader(String name,String value);//����Ӧͷ�������Ӧ��Ϣ������ͬ���Ḳ��
 * 				addHeader(String name,String value);//����Ӧͷ�������Ӧ��Ϣ�����ǲ��Ḳ�ǡ�
 * 			������Ӧ״̬
 * 				sendError(int num,String msg);//�Զ�����Ӧ״̬�롣
 * 			������Ӧʵ��
 * 				resp.getWrite().write(String str);//��Ӧ��������ݸ������
 * 		������Ӧ�����ʽ��
 * 				resp.setContentType("text/html;charset=utf-8");
 * 		�ܽ᣺
 * 			service������������̣�
 * 				������Ӧ�����ʽ
 * 				��ȡ��������
 * 				������������
 * 					���ݿ������MVC˼�룩	
 * 				��Ӧ������
 * @author MyPC
 *
 */


public class ResponseServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
			//��ȡ������Ϣ
				//��ȡ����ͷ
				//��ȡ������
				//��ȡ�û�����
			//��������
				
			//��Ӧ������
				//������Ӧͷ
				resp.setHeader("mouse", "two fly birds");
				resp.setHeader("mouse", "bjsxt");
				resp.addHeader("key", "thinkpad");
				resp.addHeader("key", "wollo");
				//������Ӧ�����ʽ
					//resp.setHeader("content-type", "text/html;charset=utf-8");
					//resp.setContentType("text/plain;charset=utf-8");
					//resp.setContentType("text/xml;charset=utf-8");
					resp.setContentType("text/html;charset=utf-8");
				//������Ӧ״̬��
					//resp.sendError(404, "this Method is not supported");
				//������Ӧʵ��
					resp.getWriter().write("<b>����������ã��ʺ�ѧϰ</b>");
				
				
	}
}
