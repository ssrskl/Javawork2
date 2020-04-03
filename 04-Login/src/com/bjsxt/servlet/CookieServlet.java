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
 * Cookie��ϢУ��
 * 		�ж��������Ƿ�Я����ȷ��Cookie��Ϣ
 * 		�������У��Cookie��Ϣ�Ƿ���ȷ
 * 			���У����ȷ��ֱ����Ӧ��ҳ����û�
 * 			���У�鲻��ȷ����Ӧ��¼ҳ����û�
 * 		û��������ת������¼ҳ��
 * @author MyPC
 */
public class CookieServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//������������ʽ
			req.setCharacterEncoding("utf-8");
		//������Ӧ�����ʽ
			resp.setContentType("text/html;charset=utf-8");
		//��ȡ������Ϣ
			//��ȡCookie��Ϣ
			Cookie[] cks=req.getCookies();
		//����������Ϣ
			if(cks!=null){
				//����Cookie��Ϣ
					String uid="";
					for(Cookie c:cks){
						if("uid".equals(c.getName())){
							uid=c.getValue();
						}
					}
				//У��UID�Ƿ����
					if("".equals(uid)){
						//����ת��
						req.getRequestDispatcher("page").forward(req, resp);
						return;
					}else{
						//У��UID�û���Ϣ
							//��ȡҵ������
							LoginService ls=new LoginServiceImpl();
							User u=ls.checkUidService(uid);
							if(u!=null){
								//�ض���
								resp.sendRedirect("/login/main");
								return;
							}else{
								//����ת��
								req.getRequestDispatcher("page").forward(req, resp);
								return;
							}
					}
				
			}else{
				//��Ӧ������
					//����ת��
					req.getRequestDispatcher("page").forward(req, resp);
					return;
			}
	}
}
