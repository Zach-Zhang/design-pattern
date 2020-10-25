package com.zach.design.objectOriented;

import com.alibaba.excel.util.StringUtils;

/**
 * Created by Zach
 * Date :2020/10/10 8:31
 * Description :
 * 解析token,AppId,时间戳拼接到URL中,形成新的URL;
 * 解析URL,得到token,AppId,时间戳等信息
 * Version :1.0
 */
public class ApiRequest<T> {
    private String baseUrl;
    private String token;
    private String appId;
    private long timestamp;
    private T data;

    public ApiRequest() {
    }

    public ApiRequest(String baseUrl, String token, String appId, long timestamp) {
        this.baseUrl = baseUrl;
        this.token = token;
        this.appId = appId;
        this.timestamp = timestamp;
    }

    public static ApiRequest createFromFullUrl(String url) {
        return new ApiRequest();
    }

    public String getBaseUrl() {
        return this.baseUrl;
    }

    public String getToken() {
        return token;
    }

    public String getAppId() {
        return appId;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static ApiRequest buildFromFulUrl(String url) {
        if (StringUtils.isEmpty(url)) {
            return new ApiRequest();
        }
        String baseUrl = url.substring(0, url.indexOf("?"));
        String token = url.substring(url.indexOf("token=") + 1, url.indexOf("&"));
        String appId = url.substring(url.indexOf("appId=") + 1, url.indexOf("&"));
        long timestamp = Long.valueOf(url.substring(url.indexOf("timestamp=") + 1));
        return new ApiRequest(baseUrl, token, appId, timestamp);
    }
}
