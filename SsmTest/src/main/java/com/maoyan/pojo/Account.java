package com.maoyan.pojo;

import java.io.Serializable;

/**
 * @author Maoyan
 * @data 2020/4/2 15:10
 * @Version 1.0.0
 */
public class Account implements Serializable {
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    private Integer id;
    private String name;
    private double money;
}
