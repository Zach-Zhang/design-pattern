package com.zach.proxy.search;


/**
 * @Classname ProxySearcher
 * @Description: 代理类
 * @Date 2020/3/15 22:40
 * @Created by Zach
 */
public class ProxySearcher implements Searcher {
    private RealSearcher realSearcher = new RealSearcher();

    private AccessValidator av = new AccessValidator();

    private Logger logger = new Logger();

    public String doSearch(String userId, String keyword) {
        String result ;
        if (av.validate(userId)) {
            System.out.println("验证通过");
            result = realSearcher.doSearch(userId, keyword);
        } else {
            System.out.println("验证失败");
            result = "未查询到结果";
        }
        logger.log(userId);
        return result;
    }
}
