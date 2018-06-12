package com.baizhi.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by lenovo on 2018/6/1.
 */
public class SSection implements Serializable {

    private String id;
    private String title;
    private Double ssize;
    private String duration;   //时长
    private String downPath;   //下载路径
    private Date uploadDate;
    private String status;
    private String aid;

    public SSection(String id, String title, Double ssize, String duration, String downPath, Date uploadDate, String status, String aid) {
        this.id = id;
        this.title = title;
        this.ssize = ssize;
        this.duration = duration;
        this.downPath = downPath;
        this.uploadDate = uploadDate;
        this.status = status;
        this.aid = aid;
    }

    public SSection() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getSsize() {
        return ssize;
    }

    public void setSsize(Double ssize) {
        this.ssize = ssize;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getDownPath() {
        return downPath;
    }

    public void setDownPath(String downPath) {
        this.downPath = downPath;
    }

    public Date getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(Date uploadDate) {
        this.uploadDate = uploadDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAid() {
        return aid;
    }

    public void setAid(String aid) {
        this.aid = aid;
    }

    @Override
    public String toString() {
        return "SSection{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", ssize=" + ssize +
                ", duration='" + duration + '\'' +
                ", downPath='" + downPath + '\'' +
                ", uploadDate=" + uploadDate +
                ", status='" + status + '\'' +
                ", aid='" + aid + '\'' +
                '}';
    }
}
