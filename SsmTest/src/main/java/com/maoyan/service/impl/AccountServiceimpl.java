package com.maoyan.service.impl;

import com.maoyan.pojo.Account;
import com.maoyan.service.AccountService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Maoyan
 * @data 2020/4/2 15:15
 * @Version 1.0.0
 */
@Service("accountService")
public class AccountServiceimpl implements AccountService {
    @Override
    public List<Account> findAll() {
        System.out.println("业务层查询所有的账户");
        return null;
    }

    @Override
    public void saveAccount(Account account) {
        System.out.println("业务层保存账户");
    }
}
