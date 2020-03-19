package com.zach.proxy.cglib;

import net.sf.cglib.proxy.FixedValue;

/**
 * @Classname TargetResultFixed
 * @Description:
 * @Date 2020/3/19 22:24
 * @Created by Zach
 */
public class TargetResultFixed implements FixedValue {
    @Override
    public Object loadObject() throws Exception {
        System.out.println("锁定结果");
        Object obj = 999;
        return obj;
    }
}
