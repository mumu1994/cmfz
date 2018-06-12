package com.baizhi.service;

import com.baizhi.dao.SSectionDao;
import com.baizhi.entity.SSection;
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
public class SSectionServiceImpl implements SSectionService {

    @Autowired
    private SSectionDao sectionDao;


    public void add(SSection section) {
        sectionDao.insert(section);
    }

    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<SSection> findAll() {
        List<SSection> all = sectionDao.findAll();

        return all;
    }

    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public SSection findOne(String id) {
        SSection one = sectionDao.findOne(id);
        return one;
    }

    public void update(SSection section) {
        sectionDao.update(section);
    }
}
