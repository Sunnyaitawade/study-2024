package com.dws.challenge.domain;/**
 * @name TransferRequest
 * @author NSA Studios
 * @date 9/12/2024
 */

/**
 * @name TransferRequest
 * @author NSA Studios
 * @date 9/12/2024
 */
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class TransferRequest {

    @NotNull
    private String fromAccountId;

    @NotNull
    private String toAccountId;

    @NotNull
    @Min(value = 0, message = "Transfer amount must be positive.")
    private BigDecimal amount;
}
