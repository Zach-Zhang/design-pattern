package com.zach.design.strategy;

import java.math.BigDecimal;

/**
 * Created by Zach
 * Date :2020/11/28 10:43
 * Description :
 * Version :1.0
 */
public class Order {
    private Long id;
    private BigDecimal price;
    private String title;
    private Integer amount;
    private OrderType type;

    public OrderType getType() {
        return type;
    }

    public void setType(OrderType type) {
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
