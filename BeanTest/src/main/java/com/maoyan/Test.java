package com.maoyan;

import com.maoyan.factory.BeanFactory;
import com.maoyan.impl.Accountimpl;

/**
 * @author Maoyan
 * @data 2020/3/27 16:40
 * @Version 1.0.0
 */
public class Test {
    public static void main(String[] args) {
        Accountimpl accountimpl = (Accountimpl) BeanFactory.getBean("accountService");
        System.out.println(accountimpl);
        accountimpl.saveAccount();
    }
}
