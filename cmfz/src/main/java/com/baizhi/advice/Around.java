package com.baizhi.advice;

import com.baizhi.annotation.LogAnnotation;
import com.baizhi.entity.Pic_Log;
import com.baizhi.entity.Tadmin;

import com.baizhi.service.Pic_LogService;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * Created by lenovo on 2018/6/5.
 */

//环绕的额外功能（前后都加通知）
public class Around implements MethodInterceptor {

    @Autowired
    private Pic_LogService pic_logService;
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {

         /*日志  什么人 什么时间  什么事   管理员*/
        //什么人
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpSession session = requestAttributes.getRequest().getSession();
        Tadmin tadmin = (Tadmin) session.getAttribute("tadmin");

        //save  中文 管理员添加  什么事
        Method method = methodInvocation.getMethod(); //获取添加日志的方法
        LogAnnotation annotation = method.getAnnotation(LogAnnotation.class);//获取注解
        String name = annotation.name();//获取注解的属性

        //什么时间
        Date date = new Date();

        //执行结果
        String  flag = "false";
        Object proceed = null;
        //  原始方法执行之后的结果  返回值
        try {
            //原始方法执行
            proceed = methodInvocation.proceed();
            flag = "true";
        } catch (Exception e) {
            e.printStackTrace();
            flag = "false";
        }

        Pic_Log p = new Pic_Log(null,tadmin.getName(),name,date,flag);
        pic_logService.add(p);

        return proceed;
    }
}
