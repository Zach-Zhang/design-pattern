package com.zach.design.richDomain.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * Created by Zach
 * Date :2020/10/9 22:51
 * Description :
 * Version :1.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class VirtualWalletEntity {
    private Long id;
    private Long createTime;
    private Long balance;
    private boolean isAllowedOverdraft;
    private Long overdraftAmount;
    private Long frozenAmount;

    public VirtualWalletEntity() {
    }

    public VirtualWalletEntity(Long id, Long createTime, Long balance, boolean isAllowedOverdraft, Long overdraftAmount, Long frozenAmount) {
        this.id = id;
        this.createTime = createTime;
        this.balance = balance;
        this.isAllowedOverdraft = isAllowedOverdraft;
        this.overdraftAmount = overdraftAmount;
        this.frozenAmount = frozenAmount;
    }


}
