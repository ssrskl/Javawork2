package com.maoyan.dao;

import com.maoyan.pojo.User;

/**
 * @author Maoyan
 * @data 2020/4/4 12:10
 * @Version 1.0.0
 */
public interface LoginDao {
    public User checkLoginDao(String username, String password);
}
