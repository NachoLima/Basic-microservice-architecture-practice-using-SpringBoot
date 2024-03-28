package com.dh.catalogservice.config;


import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQListenerConfig {
    @Value("${queue.movie.name}")
    private String movieQueue;

    @Bean
    public Queue queue() {
        return new Queue(this.movieQueue, false);
    };

    @Value("${queue.serie.name}")
    private String serieQueue;

    @Bean
    public Queue queue2() {
        return new Queue(this.serieQueue, false);
    }

}


