package com.maoyan.dao.impl;

/**
 * @author Maoyan
 * @data 2020/3/28 10:34
 * @Version 1.0.0
 */
public class SpringIoctestimpl {


    public SpringIoctestimpl() {
        System.out.println("对象被创建");
    }

    public void init(){
        System.out.println("Class Init");
    }

    public void destory(){
        System.out.println("Class Destory");
    }
}
