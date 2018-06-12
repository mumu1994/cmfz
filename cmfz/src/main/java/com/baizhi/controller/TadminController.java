package com.baizhi.controller;

import com.baizhi.entity.Tadmin;
import com.baizhi.service.TadminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpSession;

/**
 * Created by lenovo on 2018/5/28.
 */


@Controller
@RequestMapping("/tadmin")
@SessionAttributes(value={"tadmin"})
public class TadminController {

    @Autowired
    private TadminService tadminService;

    @RequestMapping("/login")
    public String  login(Tadmin tadmin, HttpSession session, String vcode){

        String code = (String) session.getAttribute("code");
        if(code.equals(vcode)){
            tadminService.login(tadmin);
            session.setAttribute("tadmin",tadmin);
            return "redirect:/main/main.jsp";
        }else{
            return "redirect:/login.jsp";
        }

    }


    @RequestMapping("/exit")
    public String  exit(HttpSession session, SessionStatus status){

        status.setComplete();
        session.invalidate();

        return "redirect:/login.jsp";
    }

}
