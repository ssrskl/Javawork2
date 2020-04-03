package com.maoyan.service;

import com.maoyan.pojo.Account;

import java.util.List;

/**
 * @author Maoyan
 * @data 2020/4/2 15:14
 * @Version 1.0.0
 */
public interface AccountService {
    public List<Account> findAll();
    //保存账户信息
    public void saveAccount(Account account);
}
