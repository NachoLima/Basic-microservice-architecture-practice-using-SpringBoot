package com.dh.catalogservice.queue;

import com.dh.catalogservice.Service.GeneroService;
import com.dh.catalogservice.model.Movie;
import com.dh.catalogservice.model.Serie;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class MovieListener {

        @Autowired
        private GeneroService generoService;

        //Recibe un objeto Serie y lo guarda en la base de datos de catalogo
        @RabbitListener(queues = {"${queue.movie.name}"})
        public void receive(@Payload Movie movie) {
            generoService.saveMovie(movie);
            System.out.println("Pelicula recibida: " + movie);
        }



    }

