package com.zach.proxy.search;

import java.util.Arrays;
import java.util.List;

/**
 * @Classname AccessValidator
 * @Description: 验证类
 * @Date 2020/3/15 22:41
 * @Created by Zach
 */
public class AccessValidator {
    private static final List<String> list = Arrays.asList("吉泽明步", "波多野结衣", "泷泽萝拉");

    public boolean validate(String userId) {
        System.out.println("开始验证用户的id为" + userId + "是否为合法用户");
        return list.contains(userId) ? true : false;
    }
}
