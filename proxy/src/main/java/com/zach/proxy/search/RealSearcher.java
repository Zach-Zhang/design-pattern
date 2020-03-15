package com.zach.proxy.search;

/**
 * @Classname RealSearcher
 * @Description: 需要被代理的真实查询类
 * @Date 2020/3/15 22:35
 * @Created by Zach
 */
public class RealSearcher implements Searcher {
    public String doSearch(String userId, String keyword) {
        return "搜索用户id为" + userId + ",关键词是: " + keyword;
    }
}
