package com.zach.design.richDomain.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zach.design.richDomain.domain.VirtualWalletEntity;

import java.math.BigDecimal;

/**
 * Created by Zach
 * Date :2020/10/12 21:59
 * Description :
 * Version :1.0
 */
public interface VirtualWalletMapper extends BaseMapper<VirtualWalletEntity> {
    BigDecimal getBalance(Long walletId);

    int updateBalance(Long walletId, BigDecimal balance);
}
