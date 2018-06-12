package com.baizhi.controller;


import com.baizhi.entity.FileParam;
import com.baizhi.entity.SSection;
import com.baizhi.service.SSectionService;
import com.baizhi.service.SSectionServiceImpl;
import com.baizhi.util.UploadUtil;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by lenovo on 2018/5/31.
 */

@Controller
@RequestMapping("/section")
public class SSectionController {

    @Autowired
    private SSectionService sectionService;

    @RequestMapping(value = "/add",produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public String add(SSection section, MultipartFile addFile, HttpServletRequest request,String album_id){
        FileParam fileParam = UploadUtil.addFile(addFile, request, UploadUtil.FILE);
        System.out.println(fileParam.getUrl());
        System.out.println(fileParam.getOldName());

        UUID uuid = UUID.randomUUID();
        String uid = uuid.toString();
        section.setId(uid);
        section.setAid(album_id);
        System.out.println(album_id);
        section.setUploadDate(new Date());
        section.setDownPath(fileParam.getUrl());
       /* section.setDownPath("/audio/"+fileParam.getOldName());*/
        sectionService.add(section);
        return "add";
    }

    @RequestMapping(value = "/show",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<SSection> showAll(){
        List<SSection> all = sectionService.findAll();
        return all;
    }


    /*下载*/
    @RequestMapping("/down")
    @ResponseBody
    public void down(String downPath, String title, HttpServletRequest request, HttpServletResponse response){

        //     文件存储位置          downPath:/audio/b0879e48-fb84-4e93-b0e2-faaaee297f9f.mp3         歌曲.mp3
        String projectPath = request.getSession().getServletContext().getRealPath("/");
        File file = new File(projectPath);
        String webappsPath = file.getParent();
        String filePath = webappsPath + downPath;
        File downFile = new File(filePath);

        //设置响应头   响应类型

        String fileName = null;
        try {
            fileName= new String(title.getBytes("UTF-8"),"ISO8859-1");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        response.setHeader("content-disposition","attachment;fileName="+fileName);
        response.setContentType("audio/mpeg");

        //响应出去
        try {
            ServletOutputStream outputStream = response.getOutputStream();
            outputStream.write(FileUtils.readFileToByteArray(downFile));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
