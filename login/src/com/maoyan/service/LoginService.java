package com.maoyan.service;

import com.maoyan.pojo.User;

public interface LoginService {
    //校验用户登录信息
    User checkLoginService(String uname,String pwd);
}
