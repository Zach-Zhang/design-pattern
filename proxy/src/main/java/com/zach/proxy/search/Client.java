package com.zach.proxy.search;

/**
 * @Classname Client
 * @Description:
 * @Date 2020/3/15 23:03
 * @Created by Zach
 */
public class Client {
    public static void main(String[] args) {
        Searcher searcher = new ProxySearcher();
        String result = searcher.doSearch("泷泽萝拉", "雅蠛蝶");
        System.out.println(result);
    }
}
