package com.zach.proxy.dynamic;

/**
 * @Classname BookfacadeImpl
 * @Description:
 * @Date 2020/3/18 23:26
 * @Created by Zach
 */
public class BookfacadeImpl implements BookFacade {


    public void addBook() {
        System.out.println(" add book logic is running!");
    }

    public void deleteBook() {
        System.out.println("delete book logic is running!");
    }
}
