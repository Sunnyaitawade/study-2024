package com.ms.eventdriven.stock_service.kafka;/**
 * @name OrderConsumer
 * @author NSA Studios
 * @date 8/26/2024
 */

import com.ms.eventdriven.base_domains.dto.OrderEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

/**
 * @author NSA Studios
 * @name OrderConsumer
 * @date 8/26/2024
 */
@Slf4j
@Service
public class OrderConsumer {

    @KafkaListener(topics = "${spring.kafka.topic.name}", groupId = "${spring.kafka.consumer.group-id}")
    public void consumeOrder(OrderEvent orderEvent) {

        log.info(String.format("Order event received in stock service =>%S ",orderEvent.toString()));

        //save order event data into db here
    }

}
