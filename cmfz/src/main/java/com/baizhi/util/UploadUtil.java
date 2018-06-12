package com.baizhi.util;

import com.baizhi.entity.FileParam;
import org.apache.commons.io.FilenameUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * Created by lenovo on 2018/5/31.
 */

//封装上传文件
public class UploadUtil {

      //静态常量   用来判断文件的类型
      //音频的设置类型
    public static final String FILE = "FILE";
      //图片的设置类型
    public static final String IMG = "IMG";

    public static FileParam addFile(MultipartFile multipartFile, HttpServletRequest request,String type/*文件类型*/){
            //文件位置
            // 1 获取项目路径
        String projectPath = request.getSession().getServletContext().getRealPath("/");
        File file = new File(projectPath);
            //2 web项目路径
        String webappsPath = file.getParent();
            //3 创建上传文件夹
        File uploadPath;
        String url;
        if(type.equals(FILE)){
            //音频文件的上传文件夹
            uploadPath = new File(webappsPath+"/audio");
            url = "/audio";
        }else {
            //图片的上传文件夹
            uploadPath = new File(webappsPath+"/upload");
            url ="/upload";
        }

        if( ! uploadPath.exists()){
            //文件夹不存在创建   存在直接用
            uploadPath.mkdir();
        }

            //获取原始文价名
        String oldFileName = multipartFile.getOriginalFilename();
            //获取后缀名
        String extension = FilenameUtils.getExtension(oldFileName);

        UUID uuid = UUID.randomUUID();
        String newName = uuid.toString();
        newName = newName + "." +extension;

            //上传到指定文件夹
        try {
            multipartFile.transferTo(new File(uploadPath.getPath(),newName));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new FileParam(url + "/" +newName,oldFileName);
    }






}
