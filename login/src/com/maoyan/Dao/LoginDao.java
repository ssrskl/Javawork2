package com.maoyan.Dao;

import com.maoyan.pojo.User;

public interface LoginDao {
    User checkLoginDao(String uname,String pwd);
}
