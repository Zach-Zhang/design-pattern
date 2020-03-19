package com.zach.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Classname BookFacadeCglib
 * @Description: 使用CGLIB代理
 * @Date 2020/3/19 21:04
 * @Created by Zach
 */
public class BookFacadeCglib implements MethodInterceptor {
    private Object target;

    /**
     * 创建代理对象
     *
     * @param target
     * @return
     */
    public Object getInstance(Object target) {
        this.target = target;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(this.target.getClass());

        //回调方法
        enhancer.setCallback(this);

        //创建代理对象
        return enhancer.create();
    }

    /**
     * 回调方法
     *
     * @param o
     * @param method
     * @param objects
     * @param methodProxy
     * @return
     * @throws Throwable
     */
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("执行回调方法=====start");
        methodProxy.invokeSuper(o, objects);
        System.out.println("执行回调方法=====end");
        return null;
    }
}
