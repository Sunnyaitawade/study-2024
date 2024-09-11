package com.dws.challenge.service;/**
 * @name WithdrawServiceImpl
 * @author NSA Studios
 * @date 9/12/2024
 */

/**
 * @name WithdrawServiceImpl
 * @author NSA Studios
 * @date 9/12/2024
 */

import com.dws.challenge.domain.Account;
import com.dws.challenge.exception.InsufficientBalanceException;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class WithdrawServiceImpl implements WithdrawService{


    @Override
    public void withdraw(Account account, BigDecimal amount) throws InsufficientBalanceException {
        synchronized (account) {
            if (account.getBalance().compareTo(amount) >= 0) {   // Ensure the account has enough balance
                account.setBalance(account.getBalance().subtract(amount));
            } else {
                throw new InsufficientBalanceException("Insufficient balance in account ID: " + account.getAccountId());
            }
        }
    }
}
