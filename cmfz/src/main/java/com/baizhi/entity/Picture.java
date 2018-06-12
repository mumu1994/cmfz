package com.baizhi.entity;

//import com.baizhi.commons.JsonDateSerilizer;
import com.baizhi.commons.JsonDateSerilizer;
import com.baizhi.poi.PictureAnnoation;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by lenovo on 2018/5/29.
 */
public class Picture implements Serializable{

    @PictureAnnoation(name="编号")
    private Integer id;

    @PictureAnnoation(name="图片名称")
    private String title;

    @PictureAnnoation(name="图片路径")
    private String imgPath;

    @PictureAnnoation(name="描述")
    private String pdesc;

    @PictureAnnoation(name="状态")
    private String status;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    //@JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    @JsonSerialize(using=JsonDateSerilizer.class)
    @PictureAnnoation(name="上传日期")
    private Date pdate;

    public Picture() {
    }

    public Picture(Integer id, String title, String imgPath, String pdesc, String status, Date pdate) {
        this.id = id;
        this.title = title;
        this.imgPath = imgPath;
        this.pdesc = pdesc;
        this.status = status;
        this.pdate = pdate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public String getPdesc() {
        return pdesc;
    }

    public void setPdesc(String pdesc) {
        this.pdesc = pdesc;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getPdate() {
        return pdate;
    }

    public void setPdate(Date pdate) {
        this.pdate = pdate;
    }

    @Override
    public String toString() {
        return "Picture{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", imgPath='" + imgPath + '\'' +
                ", pdesc='" + pdesc + '\'' +
                ", status='" + status + '\'' +
                ", pdate=" + pdate +
                '}';
    }
}

