package com.bjsxt.service;

import com.bjsxt.pojo.User;

public interface LoginService {
	//У���û���¼��Ϣ
	User checkLoginService(String uname,String pwd);
	//У���û�Cookie��Ϣ
	User checkUidService(String uid);
}	
