package com.baizhi.service;

import com.baizhi.annotation.LogAnnotation;
import com.baizhi.dao.PictureDao;
import com.baizhi.entity.Picture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by lenovo on 2018/5/29.
 */

@Service
@Transactional
public class PictureServiceImpl implements PictureService {

    @Autowired
    private PictureDao pictureDao;

    @LogAnnotation(name="这个是添加轮播图")
    public void add(Picture picture) {

        pictureDao.insert(picture);

    }

    @LogAnnotation(name="这是删除轮播图")
    public void delete(Integer id) {
        pictureDao.delete(id);
    }

    @LogAnnotation(name="这是修改轮播图")
    public void update(Picture picture) {
        pictureDao.update(picture);
    }

    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<Picture> findAll() {

        List<Picture> pictures = pictureDao.findAll();

        return pictures;
    }

    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public Picture findOne(Integer id) {
        Picture picture = pictureDao.findOne(id);
        return picture;
    }
}
