package com.maoyan.service.impl;

import com.maoyan.pojo.Account;
import com.maoyan.service.AccountService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Maoyan
 * @data 2020/4/2 16:06
 * @Version 1.0.0
 */
@Service("service")
public class AccountServiceImpl implements AccountService {
    public List<Account> findAll() {
        System.out.println("业务层");
        return null;
    }
}
