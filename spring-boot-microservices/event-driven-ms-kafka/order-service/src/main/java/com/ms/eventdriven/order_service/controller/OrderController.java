package com.ms.eventdriven.order_service.controller;/**
 * @name OrderController
 * @author NSA Studios
 * @date 8/21/2024
 */

import com.ms.eventdriven.base_domains.dto.Order;
import com.ms.eventdriven.base_domains.dto.OrderEvent;
import com.ms.eventdriven.order_service.kafka.OrderProducer;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @name OrderController
 * @author NSA Studios
 * @date 8/21/2024
 */
@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
public class OrderController {

    private final OrderProducer orderProducer;

    @PostMapping("/placeOrder")
    public String placeOrder(@RequestBody  Order order) {

        order.setOrderId(UUID.randomUUID().toString());

        OrderEvent orderEvent = new OrderEvent();
        orderEvent.setStatus("PENDING");
        orderEvent.setOrder(order);
        orderEvent.setMessage("Order status is pending state");

        orderProducer.sendMessage(orderEvent);

        return "Order placed successfully...........";
    }


}
