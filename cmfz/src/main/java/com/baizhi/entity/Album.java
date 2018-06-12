package com.baizhi.entity;
import java.io.Serializable;
import java.util.Date;
import java.util.List;


/**
 * Created by lenovo on 2018/5/31.
 */
public class Album implements Serializable {

    private String id;
    private String title;
    private String coverImg;   //封面
    private Integer acount;     //集数
    private Integer score;     //星级
    private String author;
    private String broadCast;  // 播音员
    private String brief;      // 简介
    private Date publishDate;
    private String status;
    private List<SSection> children;

    public List<SSection> getChildren() {
        return children;
    }

    public void setChildren(List<SSection> children) {
        this.children = children;
    }

    public Album(String id, String title, String coverImg, Integer acount, Integer score, String author, String broadCast, String brief, Date publishDate, String status) {
        this.id = id;
        this.title = title;
        this.coverImg = coverImg;
        this.acount = acount;
        this.score = score;
        this.author = author;
        this.broadCast = broadCast;
        this.brief = brief;
        this.publishDate = publishDate;
        this.status = status;
    }

    public Album() {
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public String getCoverImg() {
        return coverImg;
    }

    public void setCoverImg(String coverImg) {
        this.coverImg = coverImg;
    }

    public Integer getAcount() {
        return acount;
    }

    public void setAcount(Integer acount) {
        this.acount = acount;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBroadCast() {
        return broadCast;
    }

    public void setBroadCast(String broadCast) {
        this.broadCast = broadCast;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    @Override
    public String toString() {
        return "Album{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", coverImg='" + coverImg + '\'' +
                ", acount=" + acount +
                ", score=" + score +
                ", author='" + author + '\'' +
                ", broadCast='" + broadCast + '\'' +
                ", brief='" + brief + '\'' +
                ", publishDate=" + publishDate +
                ", status='" + status + '\'' +
                ", children=" + children +
                '}';
    }
}
