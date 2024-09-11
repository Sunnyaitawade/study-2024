package com.dws.challenge.service;/**
 * @name TransferService
 * @author NSA Studios
 * @date 9/12/2024
 */

import com.dws.challenge.domain.Account;
import com.dws.challenge.exception.AccountNotFoundException;
import com.dws.challenge.exception.InsufficientBalanceException;
import com.dws.challenge.repository.AccountsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @name TransferService
 * @author NSA Studios
 * @date 9/12/2024
 */
@AllArgsConstructor
@Service
public class TransferService {

    private final AccountsRepository accountsRepository;
    //private final NotificationService notificationService;
    private final WithdrawService withdrawService;

    public synchronized void transferMoney(String fromAccountId, String toAccountId, BigDecimal amount) throws InsufficientBalanceException {

        Account fromAccount = accountsRepository.getAccount(fromAccountId);
        Account toAccount = accountsRepository.getAccount(toAccountId);

        if (fromAccount == null) {
            throw new AccountNotFoundException("Account with ID " + fromAccountId + " does not exist.");
        }

        if (toAccount == null) {
            throw new AccountNotFoundException("Account with ID " + toAccountId + " does not exist.");
        }

        withdrawService.withdraw(fromAccount, amount);


        toAccount.setBalance(toAccount.getBalance().add(amount));

        // Notify both account holders -  This we will add once colleugue add the impl logic
       // notificationService.notifyAboutTransfer(fromAccount, "Transferred " + amount + " to account ID: " + toAccountId);
       // notificationService.notifyAboutTransfer(toAccount, "Received " + amount + " from account ID: " + fromAccountId);
    }
}
