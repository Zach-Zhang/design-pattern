package com.zach.design.strategy;

/**
 * Created by Zach
 * Date :2020/11/28 12:16
 * Description :
 * Version :1.0
 */
public class PromotionDiscountStrategy implements DiscountStrategy {
    @Override
    public double calDiscount(Order order) {
        return 0;
    }
}
