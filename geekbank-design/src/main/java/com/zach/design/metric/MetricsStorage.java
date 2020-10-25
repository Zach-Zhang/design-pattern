package com.zach.design.metric;

import java.util.List;
import java.util.Map;

/**
 * Created by Zach
 * Date :2020/10/21 8:17
 * Description :
 * Version :1.0
 */

public interface MetricsStorage {

    void saveRequestInfo(RequestInfo requestInfo);

    List<RequestInfo> getRequestInfos(String apiName, long startTime, long endTime);

    Map<String, List<RequestInfo>> getRequestInfos(long startTime, long endTime);
}
