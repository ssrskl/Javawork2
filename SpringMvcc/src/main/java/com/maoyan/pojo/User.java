package com.maoyan.pojo;

import javax.xml.crypto.Data;
import java.io.Serializable;
import java.util.Date;

/**
 * @author Maoyan
 * @data 2020/4/3 10:55
 * @Version 1.0.0
 */
public class User implements Serializable {
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
                ", girlFriend=" + girlFriend +
                ", date=" + date +
                '}';
    }

    private String username;
    private String password;
    private GirlFriend girlFriend;
    private Date date;

    public GirlFriend getGirlFriend() {
        return girlFriend;
    }

    public void setGirlFriend(GirlFriend girlFriend) {
        this.girlFriend = girlFriend;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
