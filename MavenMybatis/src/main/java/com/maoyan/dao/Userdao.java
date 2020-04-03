package com.maoyan.dao;

import com.maoyan.pojo.User;

import java.util.List;

/**
 * @author Maoyan
 * @data 2020/3/27 12:52
 * @Version 1.0.0
 */
public interface Userdao {
    List<User> findAllUser();
    User findFristUser();
}
