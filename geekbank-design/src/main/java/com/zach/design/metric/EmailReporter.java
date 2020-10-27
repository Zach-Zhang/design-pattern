package com.zach.design.metric;

import java.util.*;

/**
 * Created by Zach
 * Date :2020/10/22 8:32
 * Description : 邮件
 * Version :1.0
 */
public class EmailReporter implements StatViewer {
    private static final Long DAY_HOURS_IN_SECONDS = 86400L;

    private MetricsStorage metricsStorage;
    private EmailSender emailSender;
    private List<String> toAddress = new ArrayList<>();
    private Aggregator aggregator;

    public EmailReporter(MetricsStorage metricsStorage, Aggregator aggregator) {
        this(metricsStorage, new EmailSender(), aggregator);

    }

    public EmailReporter(MetricsStorage metricsStorage, EmailSender emailSender, Aggregator aggregator) {
        this.metricsStorage = metricsStorage;
        this.emailSender = emailSender;
        this.aggregator = aggregator;
    }

    public void addToAddress(String address) {
        toAddress.add(address);
    }

    public void startDailyReport() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        Date firstTime = calendar.getTime();
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                long durationInMillis = DAY_HOURS_IN_SECONDS * 1000;
                long endTimeInMillis = System.currentTimeMillis();
                long startTimeInMillis = endTimeInMillis - durationInMillis;
                Map<String, List<RequestInfo>> requestInfos = metricsStorage.getRequestInfos(startTimeInMillis, endTimeInMillis);
                metricsStorage.getRequestInfos(startTimeInMillis, endTimeInMillis);
                Map<String, RequestStat> requestStatMap = aggregator.aggregate(requestInfos, durationInMillis);
                output(requestStatMap, startTimeInMillis, endTimeInMillis);
            }
        }, firstTime, DAY_HOURS_IN_SECONDS * 1000);
    }

    @Override
    public void output(Map<String, RequestStat> requestStats, long startTimeInMillis, long endTimeMills) {
        //todo 编写邮件内容
    }
}
