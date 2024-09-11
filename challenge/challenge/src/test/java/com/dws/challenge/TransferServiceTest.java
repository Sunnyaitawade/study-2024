package com.dws.challenge;/**
 * @name TransferServiceTest
 * @author NSA Studios
 * @date 9/12/2024
 */

import com.dws.challenge.domain.Account;
import com.dws.challenge.exception.AccountNotFoundException;
import com.dws.challenge.exception.InsufficientBalanceException;
import com.dws.challenge.repository.AccountsRepository;
import com.dws.challenge.service.TransferService;
import com.dws.challenge.service.WithdrawService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * @name TransferServiceTest
 * @author NSA Studios
 * @date 9/12/2024
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class TransferServiceTest {

    @Autowired
    private TransferService transferService;

    @Autowired
    private AccountsRepository accountsRepository;

    @Autowired
    private WithdrawService withdrawService;



    @Test
    void transferMoneySuccess() throws InsufficientBalanceException {
        Account  fromAccount = new Account("acc-1", new BigDecimal("200.00"));
        Account toAccount = new Account("acc-2", new BigDecimal("50.00"));

        accountsRepository.createAccount(fromAccount);
        accountsRepository.createAccount(toAccount);
        BigDecimal amount = new BigDecimal("100.00");

        transferService.transferMoney(fromAccount.getAccountId(), toAccount.getAccountId(), amount);


        assertThat(accountsRepository.getAccount(fromAccount.getAccountId()).getBalance()).isEqualTo(new BigDecimal("100.00"));
        assertThat(accountsRepository.getAccount(toAccount.getAccountId()).getBalance()).isEqualTo(new BigDecimal("150.00"));
    }

    @Test
    void transferMoneyInsufficientBalance() {
        Account  fromAccount = new Account("acc-3", new BigDecimal("200.00"));
        Account toAccount = new Account("acc-4", new BigDecimal("50.00"));

        accountsRepository.createAccount(fromAccount);
        accountsRepository.createAccount(toAccount);
        BigDecimal amount = new BigDecimal("300.00");


        assertThatThrownBy(() -> transferService.transferMoney(fromAccount.getAccountId(), toAccount.getAccountId(), amount))
                .isInstanceOf(InsufficientBalanceException.class)
                .hasMessageContaining("Insufficient balance");
    }

    @Test
    void transferMoneyNonExistentAccount() {
        Account  fromAccount = new Account("acc-7", new BigDecimal("200.00"));
        Account toAccount = new Account("acc-9", new BigDecimal("50.00"));

        accountsRepository.createAccount(fromAccount);
        accountsRepository.createAccount(toAccount);
        BigDecimal amount = new BigDecimal("50.00");
        String nonExistentAccountId = "nonexistent";


        assertThatThrownBy(() -> transferService.transferMoney(fromAccount.getAccountId(), nonExistentAccountId, amount))
                .isInstanceOf(AccountNotFoundException.class)
                .hasMessageContaining("Account with ID nonexistent does not exist.");
    }

}
