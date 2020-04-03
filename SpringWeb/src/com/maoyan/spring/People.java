package com.maoyan.spring;

/**
 * @author Maoyan
 * @date 2020/3/26 18:19
 */
public class People {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private String name;
    private int age;
}
