package com.dh.catalogservice.queue;

import com.dh.catalogservice.Service.GeneroService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import com.dh.catalogservice.model.Serie;

@Component
public class SerieListener {

    //Inyecto el servicio de genero
    @Autowired
    private GeneroService generoService;

    //Recibe un objeto Serie y lo guarda en la base de datos de catalogo
    @RabbitListener(queues = {"${queue.serie.name}"})
        public void receive(@Payload Serie serie) {
            generoService.saveSerie(serie);
            System.out.println("Serie recibida: " + serie);
        }



}
