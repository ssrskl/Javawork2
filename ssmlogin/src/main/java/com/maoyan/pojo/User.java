package com.maoyan.pojo;

import java.io.Serializable;

/**
 * @author Maoyan
 * @data 2020/4/4 11:29
 * @Version 1.0.0
 */
public class User implements Serializable {
    private Integer uid;
    private String username;
    private String password;

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
