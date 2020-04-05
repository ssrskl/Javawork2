package com.maoyan.service;

import com.maoyan.pojo.User;

/**
 * @author Maoyan
 * @data 2020/4/4 11:31
 * @Version 1.0.0
 */
public interface LoginService {
    public User Login(String username,String password);
}
