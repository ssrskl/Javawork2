package com.bjsxt.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.bjsxt.pojo.User;
import com.bjsxt.service.UserService;
import com.bjsxt.service.impl.UserServiceImpl;
/**
 * Servlet�ض���·���ܽ᣺
 * 	���·�����ӵ�ǰ�����·��������Դ��·��
 * 		���·�����servlet�ı����а���Ŀ¼��������ض�����Դ����ʧ�ܡ�
 * 	����·������һ��/��ʾ��������Ŀ¼
 * 		/������Ŀ��/��Դ·��
 * 
 * Servlet����ת����
 * 		/��ʾ��Ŀ��Ŀ¼��
 * 		req.getRequestDispatcher("/��Դ·��").forward(req, resp);
 * 
 * @author MyPC
 *
 */
public class UserServlet extends HttpServlet {
	//������־����
	Logger logger =Logger.getLogger(UserServlet.class);
	//��ȡservice�����
	UserService us=new UserServiceImpl();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//������������ʽ
		req.setCharacterEncoding("utf-8");
		//������Ӧ�����ʽ
		resp.setContentType("text/html;charset=utf-8");
		//��ȡ������
		String oper=req.getParameter("oper");
		if("login".equals(oper)){
			//���õ�¼������
			checkUserLogin(req,resp);
		}else if("out".equals(oper)){
			//�����˳�����
			userOut(req,resp);
		}else if("pwd".equals(oper)){
			//���������޸Ĺ���
			userChangePwd(req,resp);	
		}else if("show".equals(oper)){
			//������ʾ�����û�����
			userShow(req,resp);
		}else if("reg".equals(oper)){
			//����ע�Ṧ��
			userReg(req,resp);
		}else{
			logger.debug("û���ҵ���Ӧ�Ĳ�������"+oper);
		}
	}
	//ע���û�
	private void userReg(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		//��ȡ������Ϣ
			String uname=req.getParameter("uname");
			String pwd=req.getParameter("pwd");
			String sex=req.getParameter("sex");
			int age=req.getParameter("age")!=""?Integer.parseInt(req.getParameter("age")):0;
			String birth=req.getParameter("birth");
			String[] bs=null;
			if(birth!=""){
				bs=birth.split("/");
				birth=bs[2]+"-"+bs[0]+"-"+bs[1];
			}
			System.out.println(uname+":"+pwd+":"+sex+":"+age+":"+birth);
			User u=new User(0, uname, pwd, sex, age, birth);
		//����������Ϣ
			//����ҵ��㴦��
			int index=us.userRegService(u);
		//��Ӧ������
			if(index>0){
				//��ȡsession
				HttpSession hs=req.getSession();
				hs.setAttribute("reg", "true");
				//�ض���
				resp.sendRedirect("/mg/login.jsp");
			}
		
	}
	//��ʾ���е��û���Ϣ
	private void userShow(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//��������
			//����service
			List<User> lu=us.userShowService();
			//�ж�
			if(lu!=null){
				//����ѯ���û����ݴ洢��request����
				req.setAttribute("lu",lu);
				//����ת��
				req.getRequestDispatcher("/user/showUser.jsp").forward(req, resp);
				return;
			}
		
	}
	//�û��޸�����
	private void userChangePwd(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		//��ȡ����
			String newPwd=req.getParameter("newPwd");
			//��session�л�ȡ�û���Ϣ
			User u=(User)req.getSession().getAttribute("user");
			int uid=u.getUid();
		//��������
			//����service����
			int index=us.userChangePwdService(newPwd,uid);
			if(index>0){
				//��ȡsession����
				HttpSession hs=req.getSession();
				hs.setAttribute("pwd","true");
				//�ض��򵽵�¼ҳ��
				resp.sendRedirect("/mg/login.jsp");
			}
	}
	//�û��˳�
	private void userOut(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		//��ȡsession����
		HttpSession hs=req.getSession();
		//ǿ������session
		hs.invalidate();
		//�ض��򵽵�¼ҳ��
		resp.sendRedirect("/mg/login.jsp");
	}
	//�����¼
	private void checkUserLogin(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
				//��ȡ������Ϣ
				String uname=req.getParameter("uname");
				String pwd=req.getParameter("pwd");
				//����������Ϣ
					//У��
					User u=us.checkUserLoginService(uname, pwd);
					if(u!=null){
						//��ȡsession����
						HttpSession hs=req.getSession();
						//���û����ݴ洢��session��
						hs.setAttribute("user", u);
						//�ض���
						resp.sendRedirect("/mg/main/main.jsp");
						return;
					}else{
						//��ӱ�ʶ����request��
						req.setAttribute("flag",0);
						//����ת��
						req.getRequestDispatcher("/login.jsp").forward(req, resp);
						return;
					}
				//��Ӧ������
					//ֱ����Ӧ
					//����ת��
					
					
	}
	
	
}
