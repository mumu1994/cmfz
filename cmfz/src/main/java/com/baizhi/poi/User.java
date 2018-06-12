package com.baizhi.poi;

import com.baizhi.poi.UserAnnoation;

import java.util.Date;

/**
 * Created by Administrator on 2018/6/4.
 */

public class User {
    @UserAnnoation(name = "编号")
    private Integer id;

    @UserAnnoation(name = "名字")
    private String name;

    @UserAnnoation(name = "密码")
    private String password;

    @UserAnnoation(name = "日期")
    private Date date;

    public User() {
    }

    public User(Integer id, String name, String password, Date date) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.date = date;
    }

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", date=" + date +
                '}';
    }
}
