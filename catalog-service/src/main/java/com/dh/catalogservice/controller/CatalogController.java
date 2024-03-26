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

    @Autowired
    private IMovieClient iMovieClient;

    @Autowired
    private ISerieClient iSerieClient;
    @Autowired
    private GeneroService generoService;

    @GetMapping("/catalog/movie/{genre}")
    public ResponseEntity<List<Movie>> getMovieByGenre(@PathVariable String genre) {
        ResponseEntity<List<Movie>> movies = iMovieClient.getMovieByGenre(genre);

        log.info("Response received from port: {}", movies.getHeaders().getFirst("Port"));
        return movies;
    }

    @GetMapping("/catalog/{genre}")
    public Genero getGeneroByNombre(@PathVariable String genre) {
        return generoService.getGeneroByNombre(genre);
    }


    @PostMapping("/catalog/movie/save")
    public ResponseEntity<Movie> saveMovie(@RequestBody Movie movie) {
        return iMovieClient.saveMovie(movie);
    }

    @GetMapping("/catalog/series/{genre}")
    public List<Serie> getSerieByGenre(@PathVariable String genre) {
        return iSerieClient.getSerieByGenre(genre);
    }
    @PostMapping("/catalog/series/save")
    public String createSerie(@RequestBody Serie serie) {
        return iSerieClient.create(serie);
    }

}

