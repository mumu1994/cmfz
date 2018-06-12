package com.baizhi.controller.webController;

import com.alibaba.fastjson.JSONObject;
import com.baizhi.entity.Album;
import com.baizhi.entity.SSection;
import com.baizhi.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2018/6/6.
 */

@Controller
@RequestMapping("/detail")
public class SecondPage {

    @Autowired
    private AlbumService albumService;

    @RequestMapping("/wen")
    @ResponseBody
    public JSONObject wen(String id,String uid){

        JSONObject jsonObject = new JSONObject();

        if(id == null && uid ==null){
            jsonObject.put("error","选呀");
        }else if(uid == null){
            jsonObject.put("error","先登录");

        }else if(id == null){
            jsonObject.put("error","选一个专辑");
        }else {
            Album album = albumService.findOne(id);
            jsonObject.put("thumbnail",album.getCoverImg());
            jsonObject.put("title",album.getTitle());
            jsonObject.put("score",album.getScore());
            jsonObject.put("author",album.getAuthor());
            jsonObject.put("broadcast",album.getBroadCast());
            jsonObject.put("set_count",album.getAcount());
            jsonObject.put("bried",album.getBrief());
            jsonObject.put("create_date",album.getPublishDate());

            List<SSection> sections = album.getChildren();
            ArrayList<SSection> sSections = new ArrayList<SSection>();
            for (SSection section : sections) {
                SSection section1 = new SSection();

                section1.setTitle(section.getTitle());
                section1.setDownPath(section.getDownPath());
                section1.setSsize(section.getSsize());
                section1.setDuration(section.getDuration());
                sSections.add(section1);

            }

            jsonObject.put("list",sSections);

        }
        return jsonObject;
    }
}
