package com.dws.challenge.service;/**
 * @name WithdrawService
 * @author NSA Studios
 * @date 9/12/2024
 */

import com.dws.challenge.domain.Account;
import com.dws.challenge.exception.InsufficientBalanceException;

import java.math.BigDecimal;

/**
 * @name WithdrawService
 * @author NSA Studios
 * @date 9/12/2024
 */
public interface WithdrawService {
    void withdraw(Account account, BigDecimal amount) throws InsufficientBalanceException;
}
