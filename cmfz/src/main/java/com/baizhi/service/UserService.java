package com.baizhi.service;

import com.baizhi.entity.Province;
import com.baizhi.entity.User;

import java.util.List;

/**
 * Created by lenovo on 2018/6/3.
 */
public interface UserService {



    public Integer queryFirst();
    public Integer querySecond();
    public Integer queryThird();
    public Integer queryForth();
    public void update(String id, String status);

    public List<Province> queryByProM();
    public List<Province> queryByProF();

    public User queryBy(String phone);

    public void register(User user);

    public void updateUser(User user);

    public User queryByID(String id);

    public List<User> queryAll(String uid);




}
