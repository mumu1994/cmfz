package com.baizhi.controller.webController;

import com.alibaba.fastjson.JSONObject;
import com.baizhi.entity.Album;
import com.baizhi.entity.Artical;
import com.baizhi.entity.Picture;
import com.baizhi.service.AlbumService;
import com.baizhi.service.ArticalService;
import com.baizhi.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by lenovo on 2018/6/6.
 */


@Controller

public class FirstPageController {

    @Autowired
    private ArticalService articalService;

    @Autowired
    private PictureService pictureService;

    @Autowired
    private AlbumService albumService;


    @RequestMapping("/first_page")
    @ResponseBody
    public JSONObject first_Page(String uid, String ttype, String sub_type) {

        JSONObject jsonObject = new JSONObject();


        if(uid == null && ttype == null && sub_type ==null){
            jsonObject.put("error","至少选一个");
        }else if(uid == null){
            jsonObject.put("error","先登录");
        }else{
            if (ttype.equals("all")) {
                List<Artical> articals = articalService.queryGuru();
                List<Picture> pictures = pictureService.findAll();
                List<Album> albums = albumService.findAll();


                jsonObject.put("header", pictures);
                jsonObject.put("album", albums);
                jsonObject.put("artical", articals);
            } else if (ttype.equals("wen")) {
                List<Album> all = albumService.findAll();
                jsonObject.put("album", all);
            } else if (ttype.equals("si")) {
                if (sub_type.equals("ssyj")) {
                    List<Artical> articals = articalService.queryGuru();
                    jsonObject.put("artical", articals);

                } else if (sub_type.equals("xmfy")) {
                    List<Artical> articals = articalService.queryOther();
                    jsonObject.put("artical", articals);

                }else{
                    jsonObject.put("error","文章没有这个");
                }

            }else{
                jsonObject.put("error","不要乱搞");

            }

        }

        return jsonObject;

    }
}

