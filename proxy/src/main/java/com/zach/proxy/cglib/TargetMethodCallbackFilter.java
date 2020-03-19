package com.zach.proxy.cglib;

import net.sf.cglib.proxy.CallbackFilter;

import java.lang.reflect.Method;

/**
 * @Classname TargetMethodCallbackFilter
 * @Description: 回调过滤器
 * @Date 2020/3/19 21:32
 * @Created by Zach
 */
public class TargetMethodCallbackFilter implements CallbackFilter {
    /**
     * 过滤方法
     * 返回的值为数字,代表了Callback数组中的索引位置,要用到Callback
     *
     * @param method
     * @return
     */
    public int accept(Method method) {
        switch (method.getName()) {
            case "method1":
                System.out.println("filter method1==0");
                return 0;
            case "method2":
                System.out.println("filter method2==1");
                return 1;
            case "method3":
                System.out.println("filter method3==2");
                return 2;
            default:
                return 1;
        }

    }
}
