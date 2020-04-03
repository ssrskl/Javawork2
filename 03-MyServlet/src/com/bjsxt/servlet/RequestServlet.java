package com.bjsxt.servlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * request����ѧϰ��
 * 		���ã�request�����з���˵�ǰ���������������Ϣ
 * 		ʹ�ã�
 * 			��ȡ����ͷ����
 * 					req.getMethod();//��ȡ����ʽ
 * 					req.getRequestURL();//��ȡ����URL��Ϣ
 * 					req.getRequestURI();//��ȡ����URI��Ϣ
 * 					req.getScheme();//��ȡЭ��
 * 			��ȡ����������
 * 					req.getHeader("����");//����ָ��������ͷ��Ϣ
 * 					req.getHeaderNames();//��������ͷ�ļ�����ö�ټ���
 * 			��ȡ�û�����
 * 					req.getParameter("����");//����ָ�����û�����
 * 					req.getParameterValues("����");//����ͬ����ֵͬ����������(��ѡ)�����ص����顣
 * 					req.getParameterNames()//���������û��������ݵ�ö�ټ���
 * 			ע�⣺
 * 				���Ҫ��ȡ���������ݲ����ڣ����ᱨ������null��
 * 
 * 		ע�⣺
 * 			request������tomcat����������������Ϊʵ�δ��ݸ����������servlet��service������
 * @author MyPC
 *
 */
public class RequestServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//��ȡ����ͷ����
				//��ȡ����ʽ
					String method = req.getMethod();
					System.out.println(method);
				//��ȡ����URL
					StringBuffer url=req.getRequestURL();
					System.out.println(url);
					//��ȡURI
					String uri=req.getRequestURI();
					System.out.println(uri);
				//��ȡЭ��
					String h=req.getScheme();
					System.out.println(h);
		//��ȡ����������
					//��ȡָ������������Ϣ
					String value=req.getHeader("aaa");
					System.out.println(value);
					//��ȡ���е������еļ���ö��
					Enumeration e = req.getHeaderNames();
					while(e.hasMoreElements()){
						String name=(String) e.nextElement();
						String value2=req.getHeader(name);
						System.out.println(name+":"+value2);
					}
		//��ȡ�û�����
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
					//��ȡ���е��û��������ݵļ���ö�ټ���---req.getParameterNames()	
	}
}
