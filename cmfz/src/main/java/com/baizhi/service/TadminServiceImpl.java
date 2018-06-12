package com.baizhi.service;

import com.baizhi.dao.TadminDao;
import com.baizhi.entity.Tadmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by lenovo on 2018/5/28.
 */

@Service
@Transactional
public class TadminServiceImpl implements TadminService {

    @Autowired
    private TadminDao tadminDao;

    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public void login(Tadmin tadmin) {

        Tadmin tadmin1 = tadminDao.findOne(tadmin.getName());

        if(tadmin1 == null){
            throw new RuntimeException("用户不存在");
        }else{
            if( ! tadmin.getPassword().equals(tadmin1.getPassword())){
                throw new RuntimeException("密码错误");

            }
        }
    }
}
