package com.zach.proxy.search;

/**
 * @Classname Searcher
 * @Description: 抽象查询类, 是真实查询类和代理查询类的共同接口
 * @Date 2020/3/15 22:33
 * @Created by Zach
 */
public interface Searcher {

    String doSearch(String userId, String keyword);
}
