package com.maoyan.controller;

/**
 * @author Maoyan
 * @data 2020/4/5 19:59
 * @Version 1.0.0
 */

import com.maoyan.mapper.UserMapper;
import com.maoyan.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class MybatisController {

    private UserMapper userMapper;

    @RequestMapping("/query")
    @ResponseBody
    public List<User> queryUserList(){
        List<User> users = userMapper.queryUserList();
        return users;
    }

}
