package com.baizhi.service;

import com.baizhi.entity.SSection;

import java.util.List;

/**
 * Created by lenovo on 2018/5/31.
 */
public interface SSectionService {

   public void add(SSection section);

   public List<SSection> findAll();

   public SSection findOne(String id);

   public void update(SSection section);
}
