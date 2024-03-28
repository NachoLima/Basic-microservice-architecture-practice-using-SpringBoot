package com.dh.serieservice.queue;

import com.dh.serieservice.model.Serie;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

@Component
@RequiredArgsConstructor
public class SerieSender {
    private final RabbitTemplate rabbitTemplate;
    private final Queue serieQueue;

    public void send(Serie serie) {

        this.rabbitTemplate.convertAndSend(this.serieQueue.getName(), serie);
    }

}
