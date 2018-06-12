package com.baizhi.service;

import com.baizhi.entity.Pic_Log;

import java.util.List;

/**
 * Created by lenovo on 2018/6/5.
 */
public interface Pic_LogService {

    public void add(Pic_Log pic_log);

    public List<Pic_Log> queryAll();
}
