package com.zach.design.metric;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by Zach
 * Date :2020/10/21 8:09
 * Description : 采集接口请求的数据
 * Version :1.0
 */

public class MetricsCollector {
    private MetricsStorage mestricsStorage;

    public MetricsCollector(MetricsStorage mestricsStorage) {
        this.mestricsStorage = mestricsStorage;
    }

    //收集接口请求的数据
    public void recordRequest(RequestInfo requestInfo) {
        if (requestInfo == null || StringUtils.isBlank(requestInfo.getApiName())) {
            return;
        }
        mestricsStorage.saveRequestInfo(requestInfo);
    }
}
