package com.baizhi.advice;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * Created by lenovo on 2018/6/5.
 */
public class Before implements MethodBeforeAdvice {
    public void before(Method method, Object[] args, Object target) throws Throwable {

    }
}
