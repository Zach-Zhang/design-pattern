package com.zach.design.richDomain.service;

import com.zach.design.richDomain.domain.VirtualWallet;
import com.zach.design.richDomain.domain.VirtualWalletEntity;
import com.zach.design.richDomain.domain.VirtualWalletTransactionEntity;
import com.zach.design.richDomain.mapper.VirtualWalletMapper;
import com.zach.design.richDomain.mapper.VirtualWalletTransactionMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * Created by Zach
 * Date :2020/10/12 22:09
 * Description :
 * Version :1.0
 */
@Service
public class VirtualWalletService {
    @Autowired
    private VirtualWalletMapper virtualWalletMapper;

    @Autowired
    private VirtualWalletTransactionMapper virtualWalletTransactionMapper;

    public BigDecimal getBalance(Long walletId) {
        return virtualWalletMapper.getBalance(walletId);
    }

    public void debit(Long walletId, BigDecimal amount) {
        VirtualWalletEntity walletEntity = virtualWalletMapper.selectById(walletId);
        VirtualWallet wallet = convert(walletEntity);
        wallet.debit(amount);
        virtualWalletMapper.updateBalance(walletId, wallet.balance());
    }

    private VirtualWallet convert(VirtualWalletEntity walletEntity) {
        VirtualWallet wallet = new VirtualWallet();
        BeanUtils.copyProperties(walletEntity, wallet);
        return wallet;
    }

    public void credit(Long walletId, BigDecimal amount) {
        VirtualWalletEntity walletEntity = virtualWalletMapper.selectById(walletId);
        VirtualWallet wallet = convert(walletEntity);
        wallet.credit(amount);
        virtualWalletMapper.updateBalance(walletId, wallet.balance());
    }

    public void transfer(Long fromWalletId, Long toWalletId, BigDecimal amount) {
        VirtualWalletTransactionEntity transactionEntity = new VirtualWalletTransactionEntity();
        transactionEntity.setAmount(amount);
        transactionEntity.setCreateTime(System.currentTimeMillis());
        transactionEntity.setFromWalletId(fromWalletId);
        transactionEntity.setToWalletId(toWalletId);
        transactionEntity.setStatus(1);
        Long transactionId = virtualWalletTransactionMapper.saveTransaction(transactionEntity);
        try {
            debit(fromWalletId, amount);
            credit(toWalletId, amount);
        } catch (Exception e) {
            virtualWalletTransactionMapper.updateStatus(transactionId, 0);
        }
        virtualWalletTransactionMapper.updateStatus(transactionId, 1);
    }
}
