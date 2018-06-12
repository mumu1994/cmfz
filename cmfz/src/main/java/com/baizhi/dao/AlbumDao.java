package com.baizhi.dao;

import com.baizhi.entity.Album;

import java.util.List;

/**
 * Created by lenovo on 2018/5/31.
 */
public interface AlbumDao {

    public void insert(Album album);

    public List<Album> findAll();

    public Album findOne(String id);

    public void update(Album album);


    public Album findAlbum(String id);
}
