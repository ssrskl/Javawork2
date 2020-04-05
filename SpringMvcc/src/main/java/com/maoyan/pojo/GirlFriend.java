package com.maoyan.pojo;

import java.io.Serializable;

/**
 * @author Maoyan
 * @data 2020/4/3 11:15
 * @Version 1.0.0
 */
public class GirlFriend implements Serializable {
    private String name;
    private Integer age;

    @Override
    public String toString() {
        return "GirlFriend{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
