package com.baizhi.entity;

/**
 * Created by lenovo on 2018/5/31.
 */

//文件上传后需要返回的东西
public class FileParam {

    //文件的url
    private String url;
    //文件的原名字
    private String oldName;



    public FileParam(String url, String oldName) {
        this.url = url;
        this.oldName = oldName;
    }

    public FileParam() {
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getOldName() {
        return oldName;
    }

    public void setOldName(String oldName) {
        this.oldName = oldName;
    }

    @Override
    public String toString() {
        return "FileParam{" +
                "url='" + url + '\'' +
                ", oldName='" + oldName + '\'' +
                '}';
    }
}
