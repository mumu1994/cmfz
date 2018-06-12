package com.baizhi.poi;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by lenovo on 2018/6/4.
 */

//自定义注解

//注解使用位置
@Target(ElementType.FIELD)
//注解使用时机
@Retention(RetentionPolicy.RUNTIME)
public @interface UserAnnoation {

    //该注解中有一个String类型的name属性
    public String name();
}
