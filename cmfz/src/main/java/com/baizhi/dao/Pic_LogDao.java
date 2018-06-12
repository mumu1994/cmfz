package com.baizhi.dao;

import com.baizhi.entity.Pic_Log;

import java.util.List;

/**
 * Created by lenovo on 2018/6/5.
 */
public interface Pic_LogDao {

    public void insert(Pic_Log pic_log);

    public List<Pic_Log> queryAll();
}
