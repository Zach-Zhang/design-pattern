package com.zach.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Classname BookFacadeProxy
 * @Description:
 * @Date 2020/3/18 23:28
 * @Created by Zach
 */
public class BookFacadeProxy implements InvocationHandler {
    private Object target;


    public Object bind(Object target) {
        this.target = target;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Proxy start...");
        System.out.println("method name: " + method.getName());
        Object result = method.invoke(target, args);
        System.out.println("Proxy end..." + result);
        return result;

    }
}
