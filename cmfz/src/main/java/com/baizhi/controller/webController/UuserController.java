package com.baizhi.controller.webController;

import com.alibaba.fastjson.JSONObject;
import com.baizhi.entity.FileParam;
import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import com.baizhi.util.Md5Util;
import com.baizhi.util.UploadUtil;
import org.aspectj.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2018/6/6.
 */

@Controller
@RequestMapping("/account")
public class UuserController {

    @Autowired
    private UserService userService;


    @RequestMapping("/login")
    @ResponseBody
    public JSONObject login(String phone,String password ){
        JSONObject jsonObject = new JSONObject();

        if(phone == null){
            jsonObject.put("error","请输入手机号");
        }else  if(password == null){
            jsonObject.put("error","请输入密码");
        }else{
            User user = userService.queryBy(phone);
            if(user == null){
                jsonObject.put("error","用户不存在");
            }else{
                if(Md5Util.checkPassword(password,user.getPassword())){
                    jsonObject.put("password",user.getPassword());
                    jsonObject.put("farmington",user.getDharmaName());
                    jsonObject.put("uid",user.getId());
                    jsonObject.put("nickname",user.getUsername());
                    jsonObject.put("gender",user.getSex());
                    jsonObject.put("photo",user.getHeadPic());
                    jsonObject.put("location",user.getProvice()+user.getCity());
                    jsonObject.put("province",user.getProvice());
                    jsonObject.put("city",user.getCity());
                    jsonObject.put("description",user.getSign());
                    jsonObject.put("phone",user.getPhoneNum());
                }else{
                    jsonObject.put("error","-200");
                    jsonObject.put("errmsg","密码错误");
                }

            }
        }


        return jsonObject;

    }


    @RequestMapping("/regist")
    @ResponseBody
    public JSONObject regist(String phone,String password){
        JSONObject jsonObject = new JSONObject();
        if (phone==null){
            jsonObject.put("error","手机号");
        }else if(password==null){
            jsonObject.put("error","输密码");
        }else {
            User user = userService.queryBy(phone);
            if (user!=null){
                jsonObject.put("error_msg","该手机号已经存在");
                jsonObject.put("error", "-200");
            }else {
                User uuser = new User();
                uuser.setPassword(password);
                uuser.setPhoneNum(phone);
                try {
                    userService.register(uuser);
                    System.out.println("==============1");
                    jsonObject.put("password",userService.queryBy(phone).getPassword());
                    System.out.println("=====================2");
                    jsonObject.put("uid",userService.queryBy(phone).getId());
                    System.out.println("===========3");
                    jsonObject.put("phone",userService.queryBy(phone).getPhoneNum());
                    System.out.println("==========4");
                } catch (Exception e) {
                    jsonObject.put("error_msg","不知道哪错了");
                    jsonObject.put("error", "-200");
                }
            }
        }
        return jsonObject;
    }


    @RequestMapping("/updateU")
    @ResponseBody
    public JSONObject updateU(HttpServletRequest request,MultipartFile photo, String uid, String gender, String location, String description, String nickname,

                              String province, String city, String password){
        JSONObject jsonObject = new JSONObject();
        if(uid == null){
            jsonObject.put("error","先登录");
        }else if(uid==null && gender==null && photo==null && location==null && description==null && nickname==null && province==null && city==null && password==null){
            jsonObject.put("error","改一项");

        }else{
            User user = new User();
            user.setId(uid);
            user.setSex(gender);
            user.setSign(description);
            user.setUsername(nickname);
            user.setProvice(province);
            user.setPassword(password);
            user.setCity(city);
            if(photo!=null){
                FileParam fileParam = UploadUtil.addFile(photo, request, UploadUtil.IMG);
                user.setHeadPic(fileParam.getUrl());
            }else{
                jsonObject.put("error","上传头像");
            }

            try {
                userService.updateUser(user);
                User user1 = userService.queryByID(uid);
                jsonObject.put("password",user.getPassword());
                jsonObject.put("farmington",user.getDharmaName());
                jsonObject.put("uid",user.getId());
                jsonObject.put("nickname",user.getUsername());
                jsonObject.put("gender",user.getSex());
                jsonObject.put("photo",user.getHeadPic());
                jsonObject.put("location",user.getProvice()+user.getCity());
                jsonObject.put("province",user.getProvice());
                jsonObject.put("city",user.getCity());
                jsonObject.put("description",user.getSign());
                jsonObject.put("phone",user1.getPhoneNum());
            } catch (Exception e) {
                e.printStackTrace();
                jsonObject.put("error","-200");
                jsonObject.put("error","修改失败");
            }

        }

        return jsonObject;
    }



}
