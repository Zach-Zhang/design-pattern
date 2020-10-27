package com.zach.design.metric;

import java.util.Map;

/**
 * Created by Zach
 * Date :2020/10/27 8:13
 * Description :
 * Version :1.0
 */
public interface StatViewer {
    void output(Map<String, RequestStat> requestStats, long startTimeInMillis, long endTimeMills);
}
