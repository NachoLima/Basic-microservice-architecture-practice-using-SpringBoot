package com.dh.catalogservice.config;


import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQListenerConfig {
    @Value("${queue.catalog.name}")
    private String catalogQueue;

    @Bean
    public Queue queue() {
        return new Queue(this.catalogQueue, false);
    }
}
