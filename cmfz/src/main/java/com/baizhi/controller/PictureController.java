package com.baizhi.controller;

import com.baizhi.entity.Picture;
import com.baizhi.service.PictureService;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import java.util.List;

/**
 * Created by lenovo on 2018/5/29.
 */

@Controller
@RequestMapping("/picture")
public class PictureController {

    @Autowired
    private PictureService pictureService;

    @RequestMapping(value="/add",produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody//String title,String pdesc,String status,Date pdate
    public void add(@RequestParam(value = "img") MultipartFile img, Picture pic, HttpServletRequest request){
        //1上传图片  获取到当前文件    存储位置    文件覆盖的问题（重命名）

        //获取当前项目路径
        String projectPath = request.getSession().getServletContext().getRealPath("/");
        File file = new File(projectPath);
        //web项目的路径
        String webappsPath = file.getParent();
        //上传文件夹的路径
        File uploadPath = new File(webappsPath + "/upload");
        //创建上传文件夹
        if(!uploadPath.exists()){
            uploadPath.mkdir();
        }

        //获取原始文件名
        String oldFileName = img.getOriginalFilename();
        //获取后缀名
        String extension = FilenameUtils.getExtension(oldFileName);

        UUID uuid = UUID.randomUUID();
        String newName = uuid.toString();
        newName = newName+"."+extension;
        System.out.println(newName+"==================================================");
        System.out.println(new File(uploadPath.getPath(),newName)+"======================================");
        //上传到指定的文件夹
        try {
            img.transferTo(new File(uploadPath.getPath(),newName));
        } catch (IOException e) {
            e.printStackTrace();
        }

       /* System.out.println(pdate+"---------------");
        System.out.println(pdesc);
        System.out.println(status);
        System.out.println(title);*/


        //2.将数据存储到数据库
        //Picture pic = new Picture();
        pic.setPdate(new Date());
        pic.setImgPath("/upload/"+newName);
        /*pic.setPdate(pdate);
        pic.setPdesc(pdesc);
        pic.setStatus(status);
        pic.setTitle(title);*/
        pictureService.add(pic);


    }






    @RequestMapping(value="/show",produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public Map showAll(){

        List<Picture> all = pictureService.findAll();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("total",all.size());
        map.put("rows",all);
        return map;
    }


    @RequestMapping(value = "/update",produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public String update(Integer id, String status){
        Picture picture = new Picture();

        picture.setId(id);
        picture.setStatus(status);
        picture.setPdate(new Date());
        pictureService.update(picture);

        return "string";
    }

    @RequestMapping(value="/delete",produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public String delete(Integer id){
        pictureService.delete(id);
        return "string";
    }

}
