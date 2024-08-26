package com.ms.eventdriven.order_service.config;/**
 * @name KafkaConfig
 * @author NSA Studios
 * @date 8/21/2024
 */

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

/**
 * @name KafkaConfig
 * @author NSA Studios
 * @date 8/21/2024
 */
@Configuration
public class KafkaTopicConfig {

    @Value("${spring.kafka.topic.name}")
    private String topicName;

    @Value("${spring.kafka.topic.partition}")
    private int topicPartition;

    //spring bean for kafka topic config
    @Bean
    public NewTopic topic() {
        return TopicBuilder.name(topicName)
                .partitions(topicPartition)
                .build();
    }

}
