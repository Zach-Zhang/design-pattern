package com.zach.design.richDomain.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

/**
 * Created by Zach
 * Date :2020/10/12 8:36
 * Description : 交易流水
 * Version :1.0
 */
@Data
@EqualsAndHashCode
public class VirtualWalletTransactionEntity {
    private BigDecimal amount;
    private Long createTime;
    private Long fromWalletId;
    private Long toWalletId;
    private Integer status;
}
