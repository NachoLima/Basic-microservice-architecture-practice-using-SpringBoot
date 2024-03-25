package com.dh.catalogservice.queue;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import com.dh.catalogservice.model.Serie;

@Component
public class SerieListener {

    //TODO implementar CatalogService para guardar las peliculas y series en MongoDB
    //@Autowired
    //private final CatalogService catalogService;

    @RabbitListener(queues = {"${queue.catalog.name}"})
        public void receive(@Payload Serie serie) {
            //catalogService.save(serie);
            System.out.println("Serie received: " + serie);
        }



}
