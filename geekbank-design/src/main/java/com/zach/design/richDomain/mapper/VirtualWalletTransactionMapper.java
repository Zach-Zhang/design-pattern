package com.zach.design.richDomain.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zach.design.richDomain.domain.VirtualWalletTransactionEntity;

/**
 * Created by Zach
 * Date :2020/10/12 22:26
 * Description :
 * Version :1.0
 */
public interface VirtualWalletTransactionMapper extends BaseMapper<VirtualWalletTransactionEntity> {
    Long saveTransaction(VirtualWalletTransactionEntity transactionEntity);

    void updateStatus(Long transactionId, int status);
}
