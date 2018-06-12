package com.baizhi.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by lenovo on 2018/6/5.
 */

//自定义注解

//注解使用的位置(方法上)
@Target(ElementType.METHOD)
//注解运行的时机
@Retention(RetentionPolicy.RUNTIME)
public @interface LogAnnotation {

    //String类型的name属性
    public String name();
}
