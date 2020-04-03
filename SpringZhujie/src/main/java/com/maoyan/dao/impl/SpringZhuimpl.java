package com.maoyan.dao.impl;

import org.springframework.stereotype.Component;

/**
 * @author Maoyan
 * @data 2020/3/28 13:33
 * @Version 1.0.0
 */
@Component(value = "zhutest")
public class SpringZhuimpl {

    public SpringZhuimpl() {
        System.out.println("对象创建完毕");
    }
}
