package com.zach.design.objectOriented;

import org.springframework.util.DigestUtils;

import java.util.Map;

/**
 * Created by Zach
 * Date :2020/10/17 10:50
 * Description :
 * Version :1.0
 */
public class AuthToken {
    private static final long DEFAUL_EXPIRED_TIME_INTERVAL = 1 * 60 * 1000;
    private String token;
    private long createTime;
    private long expiredTimeInterval = DEFAUL_EXPIRED_TIME_INTERVAL;

    public AuthToken(String token, long createTime) {
        this.token = token;
        this.createTime = createTime;
    }

    public AuthToken(String token, long createTime, long expiredTimeInterval) {
        this.token = token;
        this.createTime = createTime;
        this.expiredTimeInterval = expiredTimeInterval;
    }

    public static AuthToken create(String baseUrl, long createTime, Map<String, String> params) {
        String appId = params.get("appId");
        String password = params.get("password");
        String token = DigestUtils.md5DigestAsHex((baseUrl + createTime + appId + password).getBytes());
        return new AuthToken(token, createTime, DEFAUL_EXPIRED_TIME_INTERVAL);
    }

    public String getToken() {
        return this.token;
    }

    public boolean isExpired() {
        return System.currentTimeMillis() > createTime;
    }

    public boolean match(AuthToken authToken) {
        return this.getToken().equals(authToken.getToken());
    }
}
