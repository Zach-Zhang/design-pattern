package com.zach.design.metric;

import com.google.gson.Gson;

import java.util.HashMap;
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
public class ConsoleReporter {
    private MetricsStorage metricsStorage;
    private ScheduledExecutorService executor;

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
            Map<String, List<RequestInfo>> requestInfos = metricsStorage.getRequestInfos(startTime, endTime);
            Map<String, RequestStat> stats = new HashMap<>();
            for (Map.Entry<String, List<RequestInfo>> entry : requestInfos.entrySet()) {
                String apiName = entry.getKey();
                List<RequestInfo> requestInfosPerApi = entry.getValue();
                //2) 根据原始数据,计算得到统计数据
                RequestStat requestStat = Aggregator.aggregate(requestInfosPerApi, durationTime);
                stats.put(apiName, requestStat);
            }

            //3) 将统计数据显示到终端(命令行或邮件)
            System.out.println("Time Span:[" + startTime + ", " + endTime + "]");
            Gson gson = new Gson();
            System.out.println(gson.toJson(stats));
        }, 0, periodInSeconds, TimeUnit.SECONDS);
    }
}
