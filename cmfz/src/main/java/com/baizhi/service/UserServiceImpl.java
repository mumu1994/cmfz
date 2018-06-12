package com.baizhi.service;

import com.baizhi.dao.UserDao;
import com.baizhi.entity.Province;
import com.baizhi.entity.User;
import com.baizhi.util.Md5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

/**
 * Created by lenovo on 2018/6/3.
 */

@Service
@Transactional
public class UserServiceImpl  implements UserService{

    @Autowired
    private UserDao userDao;

    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public Integer queryFirst() {
        Integer first = userDao.findFirst();
        return first;
    }


    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public Integer querySecond() {
        Integer second = userDao.findSecond();
        return second;
    }

    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public Integer queryThird() {
        Integer third = userDao.findthird();
        return third;
    }

    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public Integer queryForth() {
        Integer forth = userDao.findforth();
        return forth;
    }

    public void update(String id, String status) {
        userDao.update(id,status);
    }

    public List<Province> queryByProM() {
        List<Province> provicM = userDao.queryByProvicM();
        return provicM;
    }

    public List<Province> queryByProF() {
        List<Province> provicF = userDao.queryByProvicF();
        return provicF;
    }

    public User queryBy(String phone) {
        User user = userDao.findOne(phone);
        return user;
    }

    public void register(User user) {
        System.out.println(user);
        UUID uuid = UUID.randomUUID();
        String uid = uuid.toString();
        System.out.println(uid);
        user.setId(uid);
        System.out.println(user.getId());
        user.setPassword(Md5Util.encryption(user.getPassword()));
        userDao.insert(user);
    }

    public void updateUser(User user) {

        if(user.getPassword()!=null){
            String s = Md5Util.encryption(user.getPassword());
            user.setPassword(s);
        }
        userDao.updateMore(user);
    }

    public User queryByID(String id) {
        User user = userDao.queryById(id);
        return user;
    }

    public List<User> queryAll(String uid) {
        List<User> all = userDao.findAll();
        for (User user : all) {
            if(user.getId().equals(uid)){
                all.remove(user);
            }
        }
        return all;


    }


}
