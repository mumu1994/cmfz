package com.baizhi.service;

import com.baizhi.dao.Pic_LogDao;
import com.baizhi.entity.Pic_Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by lenovo on 2018/6/5.
 */

@Service
@Transactional
public class Pic_LogServiceImpl implements Pic_LogService {

    @Autowired
    private Pic_LogDao pic_logDao;
    public void add(Pic_Log pic_log) {
        pic_logDao.insert(pic_log);
    }


    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<Pic_Log> queryAll(){
        List<Pic_Log> pic_logs = pic_logDao.queryAll();
        return pic_logs;
    }
}
