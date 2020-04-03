package com.maoyan.pojo;

import java.util.Objects;
//实体类
public class User {
    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", uname='" + uname + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return uid == user.uid &&
                Objects.equals(uname, user.uname) &&
                Objects.equals(pwd, user.pwd);
    }

    public User() {
        super();
    }

    public User(int uid,String uname,String pwd){
        super();
        this.uid = uid;
        this.uname = uname;
        this.pwd = pwd;
    }
    @Override
    public int hashCode() {

        return Objects.hash(uid, uname, pwd);
    }

    private int uid;
    private String uname;
    private String pwd;

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }


}
