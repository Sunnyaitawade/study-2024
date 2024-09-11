package com.dws.challenge;/**
 * @name WithDrawServiceTest
 * @author NSA Studios
 * @date 9/12/2024
 */

import com.dws.challenge.domain.Account;
import com.dws.challenge.exception.InsufficientBalanceException;
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
 * @name WithDrawServiceTest
 * @author NSA Studios
 * @date 9/12/2024
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class WithDrawServiceTest {

    @Autowired
    private WithdrawService withdrawService;

    @Test
    void withdrawSuccess() throws InsufficientBalanceException {
       Account account = new Account("acc1", new BigDecimal("500.00"));
        BigDecimal amount = new BigDecimal("200.00");
        withdrawService.withdraw(account, amount);
        assertThat(account.getBalance()).isEqualTo(new BigDecimal("300.00"));
    }

    @Test
    void withdrawInsufficientBalance() {
        Account account = new Account("acc1", new BigDecimal("500.00"));
        BigDecimal amount = new BigDecimal("600.00");
        assertThatThrownBy(() -> withdrawService.withdraw(account, amount))
                .isInstanceOf(InsufficientBalanceException.class)
                .hasMessageContaining("Insufficient balance in account ID: " + account.getAccountId());
    }
}
