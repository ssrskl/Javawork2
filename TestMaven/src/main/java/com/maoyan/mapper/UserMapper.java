package com.maoyan.mapper;

import com.maoyan.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Maoyan
 * @data 2020/4/5 19:45
 * @Version 1.0.0
 */
public interface UserMapper {
    public List<User> queryUserList();
}
