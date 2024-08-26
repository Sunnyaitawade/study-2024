package com.ms.eventdriven.base_domains.dto;/**
 * @name OrderEvent
 * @author NSA Studios
 * @date 8/20/2024
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @name OrderEvent
 * @author NSA Studios
 * @desc This class is used to transfer data between producer and consumer using apache kafka
 * @date 8/20/2024
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderEvent {

    private String status;
    private String message;
    private Order order;

}
