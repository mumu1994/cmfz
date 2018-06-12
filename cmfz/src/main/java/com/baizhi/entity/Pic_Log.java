package com.baizhi.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by lenovo on 2018/6/5.
 */
public class Pic_Log implements Serializable {

    private Integer id;
    private String t_name;
    private String t_thing;
    private Date t_time;
    private String t_result;

    public Pic_Log(Integer id, String t_name, String t_thing, Date t_time, String t_result) {
        this.id = id;
        this.t_name = t_name;
        this.t_thing = t_thing;
        this.t_time = t_time;
        this.t_result = t_result;
    }

    public Pic_Log() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getT_name() {
        return t_name;
    }

    public void setT_name(String t_name) {
        this.t_name = t_name;
    }

    public String getT_thing() {
        return t_thing;
    }

    public void setT_thing(String t_thing) {
        this.t_thing = t_thing;
    }

    public Date getT_time() {
        return t_time;
    }

    public void setT_time(Date t_time) {
        this.t_time = t_time;
    }

    public String getT_result() {
        return t_result;
    }

    public void setT_result(String t_result) {
        this.t_result = t_result;
    }

    @Override
    public String toString() {
        return "Pic_Log{" +
                "id=" + id +
                ", t_name='" + t_name + '\'' +
                ", t_thing='" + t_thing + '\'' +
                ", t_time=" + t_time +
                ", t_result='" + t_result + '\'' +
                '}';
    }
}
