package com.maoyan.pojo;

/**
 * @author Maoyan
 * @date 2020/3/26 19:54
 */
public class People {
    public People(String name) {
    }

    public People(String name, int age) {
        super();
        this.name = name;
        this.age = age;
        System.out.println("初始化");
    }

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
