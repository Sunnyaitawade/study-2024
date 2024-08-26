package com.ms.eventdriven.base_domains.dto;/**
 * @name Order
 * @author NSA Studios
 * @date 8/20/2024
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @name Order
 * @author NSA Studios
 * @date 8/20/2024
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    private String orderId;
    private String name;
    private int qty;
    private double price;

}
