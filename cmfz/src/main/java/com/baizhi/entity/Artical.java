package com.baizhi.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by lenovo on 2018/6/6.
 */
public class Artical implements Serializable{

    private String id;
    private String title;
    private String content;   //内容
    private String insertImgPath;//插图
    private Date publishDate;//发布日期
    private String headImg;
    private String author;


    public Artical(String id, String title, String content, String insertImgPath, Date publishDate, String headImg, String author) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.insertImgPath = insertImgPath;
        this.publishDate = publishDate;
        this.headImg = headImg;
        this.author = author;
    }

    public Artical() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getInsertImgPath() {
        return insertImgPath;
    }

    public void setInsertImgPath(String insertImgPath) {
        this.insertImgPath = insertImgPath;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Artical{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", insertImgPath='" + insertImgPath + '\'' +
                ", publishDate=" + publishDate +
                ", headImg='" + headImg + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
