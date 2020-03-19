package com.zach.proxy.cglib;

/**
 * @Classname BookFacadeImpl
 * @Description: 被代理类,没有实现接口
 * @Date 2020/3/19 21:03
 * @Created by Zach
 */
public class BookFacadeImpl {

    public void addBook(){
        System.out.println("增加图书馆的普通方法");
    }
}
