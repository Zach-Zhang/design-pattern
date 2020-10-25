package com.zach.design.objectOriented;

import org.springframework.stereotype.Service;

/**
 * Created by Zach
 * Date :2020/10/17 16:22
 * Description :
 * Version :1.0
 */
@Service
public class MysqlCredentialStorageImpl implements CredentialStorage {
    @Override
    public String getPasswordByAppId(String appId) {
        return "abc123";
    }
}
