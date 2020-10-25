package com.zach.design.objectOriented;

/**
 * Created by Zach
 * Date :2020/10/14 7:46
 * Description :
 * Version :1.0
 */
public interface APiAuthenticator {
    void auth(String url);

    void auth(ApiRequest apiRequest);
}
