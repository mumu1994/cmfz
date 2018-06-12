package com.baizhi.dao;


import com.baizhi.entity.SSection;



import java.util.List;

/**
 * Created by lenovo on 2018/5/31.
 */
public interface SSectionDao {

    public void insert(SSection section);

    public List<SSection> findAll();

    public SSection findOne(String id);

    public void update(SSection section);

}
