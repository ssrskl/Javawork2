package com.maoyan.dao;

import com.maoyan.pojo.Account;

import java.util.List;

/**
 * @author Maoyan
 * @data 2020/4/2 15:12
 * @Version 1.0.0
 */
public interface AccountDao {
    public List<Account> findAll();
    //保存账户信息
    public void saveAccount(Account account);
}
