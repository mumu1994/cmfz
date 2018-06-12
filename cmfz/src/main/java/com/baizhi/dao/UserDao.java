package com.baizhi.dao;

import com.baizhi.entity.Province;
import com.baizhi.entity.User;

import java.util.List;

/**
 * Created by lenovo on 2018/6/3.
 */
public interface UserDao {

    public Integer findFirst();
    public Integer findSecond();
    public Integer findthird();
    public Integer findforth();

    public void update(String id,String status);

    public List<Province> queryByProvicM();
    public List<Province> queryByProvicF();

    public User findOne(String phoneNum);

    public void insert(User user );

    public void updateMore(User user);

    public User queryById(String id);

    public List<User> findAll();





}
