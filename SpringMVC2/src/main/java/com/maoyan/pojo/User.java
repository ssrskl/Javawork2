package com.maoyan.pojo;

import java.io.Serializable;

/**
 * @author Maoyan
 * @data 2020/4/3 20:49
 * @Version 1.0.0
 */
public class User implements Serializable {
    public String getUsername() {
        return username;
    }

    @Override
    public String toString() {
        return "Uesr{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
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

    private String username;
    private String password;
}
