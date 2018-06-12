package com.baizhi.service;

import com.baizhi.dao.AlbumDao;
import com.baizhi.entity.Album;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by lenovo on 2018/5/31.
 */

@Service
@Transactional
public class AlbumServiceImpl implements AlbumService {

    @Autowired
    private AlbumDao albumDao;


    public void add(Album album) {
        albumDao.insert(album);
    }

    public void update(Album album) {
        albumDao.update(album);
    }

    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<Album> findAll() {
        List<Album> all = albumDao.findAll();
        return all;
    }

    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public Album findOne(String id) {
        Album album = albumDao.findOne(id);
        return album;
    }

    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public Album queryAlbum(String id) {
        Album album = albumDao.findAlbum(id);
        return album;
    }
}
