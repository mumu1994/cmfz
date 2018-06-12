package com.baizhi.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by lenovo on 2018/5/29.
 */
public class Menu implements Serializable{

    private  Integer id;
    private  String title;
    private  String iconCls;
    private  Integer parent_id;
    private  String url;
    private  List<Menu> childmenu;

    public Menu(Integer id, String title, String iconCls, Integer parent_id, String url) {
        this.id = id;
        this.title = title;
        this.iconCls = iconCls;
        this.parent_id = parent_id;
        this.url = url;
    }

    public Menu() {
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

    public String getIconCls() {
        return iconCls;
    }

    public void setIconCls(String iconCls) {
        this.iconCls = iconCls;
    }

    public Integer getParent_id() {
        return parent_id;
    }

    public void setParent_id(Integer parent_id) {
        this.parent_id = parent_id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<Menu> getChildmenu() {
        return childmenu;
    }

    public void setChildmenu(List<Menu> childmenu) {
        this.childmenu = childmenu;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", iconCls='" + iconCls + '\'' +
                ", parent_id=" + parent_id +
                ", url='" + url + '\'' +
                ", childmenu=" + childmenu +
                '}';
    }
}
