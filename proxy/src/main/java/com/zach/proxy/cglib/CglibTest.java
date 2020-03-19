package com.zach.proxy.cglib;

/**
 * @Classname CglibTest
 * @Description:
 * @Date 2020/3/19 21:28
 * @Created by Zach
 */
public class CglibTest {
    public static void main(String[] args) {
        BookFacadeCglib cglib = new BookFacadeCglib();
        BookFacadeImpl instance = (BookFacadeImpl) cglib.getInstance(new BookFacadeImpl());
        instance.addBook();
    }
}
