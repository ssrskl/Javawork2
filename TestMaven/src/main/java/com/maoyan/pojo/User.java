package com.maoyan.pojo;

import java.io.Serializable;

/**
 * @author Maoyan
 * @data 2020/4/5 19:43
 * @Version 1.0.0
 */
public class User  implements Serializable {
    private String username;
    private String password;

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

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
