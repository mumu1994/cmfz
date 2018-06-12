package com.baizhi.dao;

import com.baizhi.entity.Artical;

import java.util.List;

/**
 * Created by lenovo on 2018/6/6.
 */
public interface ArticalDao {

    public List<Artical> findGuru();

    public List<Artical> findOther();

    public Artical findOne(String id);
}
