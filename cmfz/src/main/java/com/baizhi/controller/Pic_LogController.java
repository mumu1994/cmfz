package com.baizhi.controller;

import com.baizhi.entity.Pic_Log;
import com.baizhi.service.Pic_LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lenovo on 2018/6/5.
 */

@Controller
@RequestMapping("/log")
public class Pic_LogController {

    @Autowired
    private Pic_LogService pic_logService;

    @RequestMapping("/show")
    @ResponseBody
    public Map showAll(){
        List<Pic_Log> pic_logs = pic_logService.queryAll();
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("total",pic_logs.size());
        map.put("rows",pic_logs);
        return map;
    }
}
