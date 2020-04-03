package com.bjsxt.service.impl;

import com.bjsxt.dao.LoginDao;
import com.bjsxt.dao.impl.LoginDaoImpl;
import com.bjsxt.pojo.User;
import com.bjsxt.service.LoginService;

public class LoginServiceImpl implements LoginService{
	//����Dao�������
	LoginDao ld=new LoginDaoImpl();
	//У���û���¼��Ϣ
	@Override
	public User checkLoginService(String uname, String pwd) {
		
		return ld.checkLoginDao(uname, pwd);
	}
	//У��Cookie��Ϣ
	@Override
	public User checkUidService(String uid) {
		return ld.checkUidDao(uid);
	}
	
}
