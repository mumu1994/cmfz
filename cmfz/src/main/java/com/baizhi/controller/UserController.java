package com.baizhi.controller;

import com.baizhi.entity.Province;
import com.baizhi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

/**
 * Created by lenovo on 2018/6/3.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/query",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Integer> query(){
        Integer first = userService.queryFirst();
        Integer second = userService.querySecond();
        Integer third = userService.queryThird();
        Integer forth = userService.queryForth();
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(first);
        list.add(second);
        list.add(third);
        list.add(forth);
        return list;
    }

    @RequestMapping(value = "/update" ,produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void update(String id,String status){
        userService.update(id,status);
    }

    @RequestMapping(value = "/queryByProM",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map<String,Province> queryByProM(){
        List<Province> proM = userService.queryByProM();
        Map<String,Province> mapM = new HashMap<String, Province>();
        for (Province pro: proM) {
            mapM.put(pro.getProvince(),pro);
        }
        return mapM;
    }

    @RequestMapping(value = "/queryByProF",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map<String,Province> queryByProF(){
        List<Province> proF = userService.queryByProF();
        Map<String, Province> mapF = new HashMap<String, Province>();
        for (Province pro: proF) {
            mapF.put(pro.getProvince(),pro);
        }
        return mapF;
    }

    




}
