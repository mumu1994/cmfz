package com.baizhi.service;

import com.baizhi.dao.ArticalDao;
import com.baizhi.entity.Artical;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by lenovo on 2018/6/6.
 */

@Service
@Transactional
public class ArticalServiceImpl implements ArticalService {

    @Autowired
    private ArticalDao articalDao;


    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<Artical> queryGuru() {

        List<Artical> list1 = articalDao.findGuru();

        return list1;
    }

    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<Artical> queryOther() {
        List<Artical> other = articalDao.findOther();

        return other;
    }

    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public Artical queryById(String id) {
        Artical one = articalDao.findOne(id);
        return one;
    }
}
