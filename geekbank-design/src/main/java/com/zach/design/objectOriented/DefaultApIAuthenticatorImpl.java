package com.zach.design.objectOriented;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Zach
 * Date :2020/10/14 7:45
 * Description :
 * Version :1.0
 */
@Service
public class DefaultApIAuthenticatorImpl implements APiAuthenticator {
    @Autowired
    private CredentialStorage credentialStorage;

    @Override
    public void auth(String url) {
        ApiRequest apiRequest = ApiRequest.buildFromFulUrl(url);
        auth(apiRequest);
    }

    @Override
    public void auth(ApiRequest apiRequest) {
        String appId = apiRequest.getAppId();
        String token = apiRequest.getToken();
        long timestamp = apiRequest.getTimestamp();
        String baseUrl = apiRequest.getBaseUrl();

        AuthToken clientAuthToken = new AuthToken(token, timestamp);
        if (clientAuthToken.isExpired()) {
            throw new RuntimeException("Token is expired");
        }

        String password = credentialStorage.getPasswordByAppId(appId);
        Map<String, String> params = new HashMap<>(2);
        params.put("appId", appId);
        params.put("password", password);
        AuthToken serverAuthToken = AuthToken.create(baseUrl, System.currentTimeMillis(), params);
        if (!serverAuthToken.match(clientAuthToken)) {
            throw new RuntimeException("Token verfication failed.");
        }


    }
}
