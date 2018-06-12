package com.baizhi.controller.webController;

import com.alibaba.fastjson.JSONObject;
import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by lenovo on 2018/6/6.
 */

@Controller
public class MemberController {

    @Autowired
    private UserService userService;


    @RequestMapping("/member")
    @ResponseBody
    public JSONObject member(String uid){
        JSONObject jsonObject = new JSONObject();
        if(uid!=null){
            List<User> users = userService.queryAll(uid);
            //字段赋值略
            jsonObject.put("users",users);

        }else{
            jsonObject.put("error","登录");
        }
        return jsonObject;

    }
}
