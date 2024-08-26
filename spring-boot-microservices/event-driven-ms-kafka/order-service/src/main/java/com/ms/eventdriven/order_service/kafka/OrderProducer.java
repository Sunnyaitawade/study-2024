package com.ms.eventdriven.order_service.kafka;/**
 * @name OrderProducer
 * @author NSA Studios
 * @date 8/21/2024
 */

import com.ms.eventdriven.base_domains.dto.OrderEvent;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

/**
 * @name OrderProducer
 * @author NSA Studios
 * @date 8/21/2024
 */
@Service
@AllArgsConstructor
@Slf4j
public class OrderProducer {

    private final  NewTopic topic;

    private final KafkaTemplate<String, OrderEvent> kafkaTemplate;

    public void sendMessage(OrderEvent event) {
     log.info(String.format("Order event => %S",event.toString()));

       //create message
        Message<OrderEvent> message= MessageBuilder
                .withPayload(event)
                .setHeader(KafkaHeaders.TOPIC,topic.name())
                .build();

        kafkaTemplate.send(message);

    }
}
