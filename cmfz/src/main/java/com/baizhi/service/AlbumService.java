package com.baizhi.service;


import com.baizhi.entity.Album;


import java.util.List;

/**
 * Created by lenovo on 2018/5/31.
 */


public interface AlbumService {

    public void add(Album album);

    public void update(Album album);
    public List<Album> findAll();
    public Album findOne(String id);

    public Album queryAlbum(String id );

}
