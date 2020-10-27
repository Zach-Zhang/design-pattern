package com.zach.design.metric;

import com.google.gson.Gson;

import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by Zach
 * Date :2020/10/22 7:58
 * Description :
 * Version :1.0
 */
public class ConsoleReporter implements StatViewer {
    private MetricsStorage metricsStorage;
    private ScheduledExecutorService executor;
    private Aggregator aggregator;

    public ConsoleReporter(MetricsStorage metricsStorage) {
        this.metricsStorage = metricsStorage;
        this.executor = Executors.newSingleThreadScheduledExecutor();
    }

    public void startRepeatedReport(long periodInSeconds, long durationInSeconds) {
        executor.scheduleAtFixedRate(() -> {
            //1) 根据给定的时间区间,从数据库拉取数据
            long durationTime = durationInSeconds * 1000;
            long endTime = System.currentTimeMillis();
            long startTime = endTime - durationTime;
            //获取统计数据
            Map<String, List<RequestInfo>> requestInfos = metricsStorage.getRequestInfos(startTime, endTime);
            //统计数据
            Map<String, RequestStat> requestStatMap = aggregator.aggregate(requestInfos, durationTime);
            //输出到控制台
            output(requestStatMap, startTime, endTime);
        }, 0, periodInSeconds, TimeUnit.SECONDS);
    }

    @Override
    public void output(Map<String, RequestStat> requestStats, long startTimeInMillis, long endTimeMills) {
        System.out.println("Time Span: [" + startTimeInMillis + ", " + endTimeMills + "]");
        Gson gson = new Gson();
        System.out.println(gson.toJson(requestStats));
    }
}
