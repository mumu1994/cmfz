package com.baizhi.controller;

import com.baizhi.entity.Menu;
import com.baizhi.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;

/**
 * Created by lenovo on 2018/5/29.
 */

@Controller
@RequestMapping("/menu")
@SessionAttributes(value={"menus"})
public class MenuController {

    @Autowired
    private MenuService menuService;

    @RequestMapping(value="/show",produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public List<Menu> showAll(){


        List<Menu> menus = menuService.AllMenu();

        return menus;
    }
}
