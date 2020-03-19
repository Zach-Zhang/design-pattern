package com.zach.proxy.cglib;

/**
 * @Classname TargetObject
 * @Description: 需要CGLIB动态代理的目标
 * @Date 2020/3/19 22:13
 * @Created by Zach
 */
public class TargetObject {
    public int method1(int count) {
        return count;
    }

    public int method2(int count) {
        return count;
    }

    public int method3(int count) {
        return count;
    }
}
