package com.maoyan.pojo;

/**
 * @author Maoyan
 * @data 2020/4/2 16:04
 * @Version 1.0.0
 */
public class Account {
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
