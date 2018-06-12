package com.baizhi.dao;

import com.baizhi.entity.Picture;

import java.util.List;

/**
 * Created by lenovo on 2018/5/29.
 */
public interface PictureDao {

    public void insert(Picture picture);
    public void delete(Integer id);
    public void update(Picture picture);
    public List<Picture> findAll();
    public Picture findOne(Integer id);
}
