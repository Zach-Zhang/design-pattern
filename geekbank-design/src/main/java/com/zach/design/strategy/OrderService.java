package com.zach.design.strategy;

/**
 * Created by Zach
 * Date :2020/11/28 12:18
 * Description :
 * Version :1.0
 */
public class OrderService {
    public double discount(Order order) {
        OrderType type = order.getType();
        //从工厂中获取缓存好的实现类
        DiscountStrategy discountStrategy = DiscountStrategyFactory.getDiscountStrategy(type);
        return discountStrategy.calDiscount(order);
    }
}
