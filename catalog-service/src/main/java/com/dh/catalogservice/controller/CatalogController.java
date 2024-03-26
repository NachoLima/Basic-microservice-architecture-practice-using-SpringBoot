package com.dh.catalogservice.controller;

import com.dh.catalogservice.Service.GeneroService;
import com.dh.catalogservice.client.IMovieClient;
import com.dh.catalogservice.client.ISerieClient;
import com.dh.catalogservice.model.Genero;
import com.dh.catalogservice.model.Serie;
import com.dh.catalogservice.model.Movie;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class CatalogController {

    //Inyecto el cliente de movie
    @Autowired
    private IMovieClient iMovieClient;

    //Inyecto el cliente de serie
    @Autowired
    private ISerieClient iSerieClient;

    //Inyecto el servicio de genero
    @Autowired
    private GeneroService generoService;

    //Endpoint para buscar por genero en la base de datos de catalogo
    @GetMapping("/catalog/{genre}")
    public Genero getGeneroByNombre(@PathVariable String genre) {
        return generoService.getGeneroByNombre(genre);
    }


    //Endpoint para obtener las peliculas por genero a travez de Feign Client de movie
    @GetMapping("/catalog/movie/{genre}")
    public ResponseEntity<List<Movie>> getMovieByGenre(@PathVariable String genre) {
        ResponseEntity<List<Movie>> movies = iMovieClient.getMovieByGenre(genre);

        log.info("Response received from port: {}", movies.getHeaders().getFirst("Port"));
        return movies;
    }

    //Endpoint para guardar una pelicula en la base de datos de Movie a travez de Feign Client de movie
    @PostMapping("/catalog/movie/save")
    public ResponseEntity<Movie> saveMovie(@RequestBody Movie movie) {
        return iMovieClient.saveMovie(movie);
    }

    //Endpoint para obtener las series por genero a travez de Feign Client de serie
    @GetMapping("/catalog/series/{genre}")
    public List<Serie> getSerieByGenre(@PathVariable String genre) {
        return iSerieClient.getSerieByGenre(genre);
    }

    //Endpoint para guardar una serie en la base de datos de serie a travez de Feign Client de serie
    @PostMapping("/catalog/series/save")
    public String createSerie(@RequestBody Serie serie) {
        return iSerieClient.create(serie);
    }

}

