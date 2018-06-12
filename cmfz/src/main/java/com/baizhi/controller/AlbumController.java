package com.baizhi.controller;

import com.baizhi.entity.Album;
import com.baizhi.entity.FileParam;
import com.baizhi.service.AlbumService;
import com.baizhi.util.UploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by lenovo on 2018/5/31.
 */

@Controller
@RequestMapping("/album")
public class AlbumController {



    @Autowired
    private AlbumService albumService;

    @RequestMapping(value = "/add",produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public String add(Album album, MultipartFile addFile, HttpServletRequest request){
        FileParam param = UploadUtil.addFile(addFile, request, UploadUtil.IMG);

        System.out.println(param.getUrl());


        UUID uuid = UUID.randomUUID();
        String uid = uuid.toString();
        album.setId(uid);
        album.setPublishDate(new Date());
        album.setCoverImg(param.getUrl());
        albumService.add(album);
        return "ok";
    }

    @RequestMapping(value = "/show",produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public List<Album> show(){
        List<Album> all = albumService.findAll();
        return all;
    }

    @RequestMapping(value = "/findOne",produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public String findOne(String id){
        Album one = albumService.findOne(id);
        return "one";
    }
}























