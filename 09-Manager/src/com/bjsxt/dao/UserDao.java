package com.bjsxt.dao;

import java.util.List;

import com.bjsxt.pojo.User;

public interface UserDao {
	/**
	 * �����û����������ѯ�û���Ϣ
	 * @param uname �û���
	 * @param pwd	����
	 * @return ���ز�ѯ�����û���Ϣ
	 */
	User checkUserLoginDao(String uname,String pwd);
	/**
	 * �����û�ID�޸��û�����
	 * @param newPwd
	 * @param uid
	 * @return
	 */
	int userChangePwdDao(String newPwd, int uid);
	/**
	 * ��ȡ���е��û���Ϣ
	 * @return
	 */
	List<User> userShowDao();
	/**
	 * �û�ע��
	 * @param u
	 * @return
	 */
	int userRegDao(User u);
}
