package com.maoyan.service.impl;

import com.maoyan.Dao.LoginDao;
import com.maoyan.Dao.impl.LoginDaoimpl;
import com.maoyan.pojo.User;
import com.maoyan.service.LoginService;

public class LoginServiceImpl implements LoginService {
    //创建Dao层过度向
    LoginDao loginDao = new LoginDaoimpl();
    @Override
    public User checkLoginService(String uname, String pwd) {
        return loginDao.checkLoginDao(uname,pwd);
    }
//    //创建Dao层过度向
//    LoginDao ld=new LoginServiceImpl();
//    //校验用户登录信息
//    @Override
//    public User checkLoginService(String uname, String pwd) {
//
//        return ld.checkLoginDao(uname, pwd);
//    }
}
