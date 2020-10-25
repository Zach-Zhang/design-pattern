package com.zach.design.richDomain.domain;

import java.math.BigDecimal;

/**
 * Created by Zach
 * Date :2020/10/8 23:02
 * Description : 使用充血模型实现虚拟钱包
 * Version :1.0
 */
public class VirtualWallet {
    private Long id;
    private Long createTime = System.currentTimeMillis();
    private BigDecimal balance = BigDecimal.ZERO;
    private boolean isAllowedOverdraft = true;
    private BigDecimal overdraftAmount = BigDecimal.ZERO;
    private BigDecimal frozenAmount = BigDecimal.ZERO;

    public VirtualWallet() {
    }

    public VirtualWallet(Long preAllocatedId) {
        this.id = preAllocatedId;
    }

    public void freeze(BigDecimal amount) {
    }

    ;

    public void unfreeze(BigDecimal amount) {
    }

    ;

    public void increaseOverdraftAmount(BigDecimal amount) {
    }

    ;

    public void decreaseOverdraftAmount(BigDecimal amount) {
    }

    ;

    public void closeOverdraft() {
    }

    ;

    public void openOverdraft() {
    }

    ;

    public BigDecimal balance() {
        return this.balance;
    }

    public void debit(BigDecimal amount) {
        if (this.balance.compareTo(amount) < 0) {
            throw new IllegalArgumentException("余额不能为负数");
        }
        this.balance.subtract(amount);

    }

    public void credit(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("参数有误");
        }
        this.balance.add(amount);
    }
}
