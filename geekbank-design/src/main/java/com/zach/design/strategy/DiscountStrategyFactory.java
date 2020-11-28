package com.zach.design.strategy;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Zach
 * Date :2020/11/28 10:53
 * Description : 策略工厂类
 * Version :1.0
 */
public class DiscountStrategyFactory {
    private static final Map<OrderType, DiscountStrategy> strategyMap = new HashMap<>();

    static {
        strategyMap.put(OrderType.NORMAL, new NormalDiscountStrategy());
        strategyMap.put(OrderType.GROUPON, new GrouponDiscountStrategy());
        strategyMap.put(OrderType.PROMOTION, new PromotionDiscountStrategy());
    }

    public static DiscountStrategy getDiscountStrategy(OrderType type) {
        return strategyMap.get(type);
    }
}
