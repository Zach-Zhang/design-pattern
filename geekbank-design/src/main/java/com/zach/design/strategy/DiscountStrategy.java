package com.zach.design.strategy;

/**
 * Created by Zach
 * Date :2020/11/28 10:41
 * Description : 折扣策略接口
 * Version :1.0
 */
public interface DiscountStrategy {
    double calDiscount(Order order);
}
