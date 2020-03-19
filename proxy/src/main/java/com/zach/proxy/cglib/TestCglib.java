package com.zach.proxy.cglib;

import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.CallbackFilter;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;

import java.lang.annotation.Target;

/**
 * @Classname TestCglib
 * @Description: (1)MethodInterceptor：方法拦截器
 * <p>
 * (2)NoOp.INSTANCE：这个NoOp表示no operator，即什么操作也不做，代理类直接调用被代理的方法不进行拦截。
 * <p>
 * (3)FixedValue：表示锁定方法返回值，无论被代理类的方法返回什么值，回调方法都返回固定值。
 * @Date 2020/3/19 21:50
 * @Created by Zach
 */
public class TestCglib {
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(TargetObject.class);
        CallbackFilter callbackFilter = new TargetMethodCallbackFilter();
        Callback noopCb = NoOp.INSTANCE;
        Callback callback = new TargetInterceptor();
        Callback fixedValue = new TargetResultFixed();
        Callback[] callbacks = new Callback[]{callback, noopCb, fixedValue};
        enhancer.setCallbacks(callbacks);
        enhancer.setCallbackFilter(callbackFilter);
        TargetObject targetObject = (TargetObject) enhancer.create();
        System.out.println(targetObject.method1(0));
        System.out.println(targetObject.method2(1));
        System.out.println(targetObject.method3(2));

    }
}
