package com.zach.proxy.dynamic;

/**
 * @Classname Client
 * @Description:
 * @Date 2020/3/18 23:40
 * @Created by Zach
 */
public class Client {
    public static void main(String[] args) {
        BookFacadeProxy proxy = new BookFacadeProxy();
        BookFacade bookFacade = BookFacade.class.cast(proxy.bind(new BookfacadeImpl()));
        bookFacade.addBook();
        System.out.println("=====================");
        bookFacade.deleteBook();
    }
}
