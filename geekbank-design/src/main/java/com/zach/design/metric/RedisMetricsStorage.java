package com.zach.design.metric;

import java.util.List;
import java.util.Map;

/**
 * Created by Zach
 * Date :2020/10/21 8:32
 * Description :
 * Version :1.0
 */
public class RedisMetricsStorage implements MetricsStorage {
    @Override
    public void saveRequestInfo(RequestInfo requestInfo) {

    }

    @Override
    public List<RequestInfo> getRequestInfos(String apiName, long startTime, long endTime) {
        return null;
    }

    @Override
    public Map<String, List<RequestInfo>> getRequestInfos(long startTime, long endTime) {
        return null;
    }
}
