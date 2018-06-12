package com.baizhi.service;

import com.baizhi.entity.Artical;

import java.util.List;

/**
 * Created by lenovo on 2018/6/6.
 */
public interface ArticalService {

    public List<Artical> queryGuru();

    public List<Artical> queryOther();

    public Artical queryById(String id);

}
