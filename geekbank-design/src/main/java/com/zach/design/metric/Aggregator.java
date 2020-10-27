package com.zach.design.metric;

import java.util.*;

/**
 * Created by Zach
 * Date :2020/10/21 21:47
 * Description : 统计数据
 * Version :1.0
 */
public class Aggregator {
    public Map<String, RequestStat> aggregate(Map<String, List<RequestInfo>> requestInfos, long durationInMillis) {
        Map<String, RequestStat> requestStatMap = new HashMap<>(requestInfos.keySet().size());
        for (Map.Entry<String, List<RequestInfo>> entry : requestInfos.entrySet()) {
            String apiName = entry.getKey();
            List<RequestInfo> value = entry.getValue();
            RequestStat requestStat = doAggregate(value, durationInMillis);
            requestStatMap.put(apiName, requestStat);
        }
        return requestStatMap;
    }

    private RequestStat doAggregate(List<RequestInfo> requestInfos, long durationInMillis) {
        List<Double> respTimes = new ArrayList<>();
        for (RequestInfo requestInfo : requestInfos) {
            double responseTime = requestInfo.getResponseTime();
            respTimes.add(responseTime);
        }
        RequestStat requestStat = new RequestStat();
        requestStat.setMaxResponseTime(aggregateMax(respTimes));
        requestStat.setMinResponseTime(aggregateMin(respTimes));
        requestStat.setAvgResponseTime(aggregateAvg(respTimes));
        requestStat.setP999ResponseTime(percentile999(respTimes));
        requestStat.setP99ResponseTime(percentile99(respTimes));
        requestStat.setTps(aggregateTps(respTimes.size(), durationInMillis / 1000));
        requestStat.setCount(respTimes.size());
        return requestStat;
    }

    private double aggregateMax(List<Double> respTimes) {
        double maxRespTime = Double.MIN_VALUE;
        for (Double responseTime : respTimes) {
            maxRespTime = responseTime > maxRespTime ? responseTime : maxRespTime;
        }
        return maxRespTime;
    }

    private double aggregateMin(List<Double> respTimes) {
        double minRespTime = Double.MAX_VALUE;
        for (Double responseTime : respTimes) {
            minRespTime = responseTime < minRespTime ? responseTime : minRespTime;
        }
        return minRespTime;
    }

    private double aggregateAvg(List<Double> respTimes) {
        int count = 0;
        double sumTime = 0.0;
        double avgTime = -1;
        for (Double responseTime : respTimes) {
            sumTime += responseTime;
            ++count;
        }
        if (count > 0) {
            return sumTime / count;
        }
        return avgTime;
    }

    private long aggregateTps(int count, double durationInMillis) {
        if (count > 0) {
            return (long) (count / durationInMillis);
        }
        return 0;
    }

    private double percentile999(List<Double> respTimes) {
        Collections.sort(respTimes);
        int size = respTimes.size();
        int index = (int) (size * 0.999);
        return respTimes.get(index);
    }

    private double percentile99(List<Double> respTimes) {
        Collections.sort(respTimes);
        int size = respTimes.size();
        int index = (int) (size * 0.99);
        return respTimes.get(index);
    }

    private double percentile(List<Double> respTimes, double ratio) {
        Collections.sort(respTimes);
        int size = respTimes.size();
        int index = (int) (size * ratio);
        return respTimes.get(index);
    }

}
