package com.baizhi.entity;

import java.io.Serializable;

/**
 * Created by lenovo on 2018/6/3.
 */
public class Province implements Serializable {

    private String province;
    private Integer nnum;

    public Province(String province, Integer nnum) {
        this.province = province;
        this.nnum = nnum;
    }

    public Province() {
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public Integer getNnum() {
        return nnum;
    }

    public void setNnum(Integer nnum) {
        this.nnum = nnum;
    }

    @Override
    public String toString() {
        return "Province{" +
                "province='" + province + '\'' +
                ", nnum=" + nnum +
                '}';
    }
}
