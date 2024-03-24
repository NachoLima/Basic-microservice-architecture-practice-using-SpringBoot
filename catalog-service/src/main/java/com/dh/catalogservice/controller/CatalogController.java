package com.dh.catalogservice.controller;

import com.dh.catalogservice.client.IMovieClient;
import com.dh.catalogservice.client.ISerieClient;
import com.dh.catalogservice.model.Serie;
import com.dh.movieservice.model.Movie;
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

    @GetMapping("/catalog/{genre}")
    public ResponseEntity<List<Movie>> getMovieByGenre(@PathVariable String genre) {
        ResponseEntity<List<Movie>> movies = iMovieClient.getMovieByGenre(genre);

        log.info("Response received from port: {}", movies.getHeaders().getFirst("Port"));
        return movies;
    }

    @PostMapping("/catalog/save")
    public ResponseEntity<Movie> saveMovie(@RequestBody Movie movie) {
        return iMovieClient.saveMovie(movie);
    }

    @GetMapping("/catalog/series")
    public List<Serie> getAllSeries() {
        List<Serie> series = iSerieClient.getAll();

        return series;
    }
    @GetMapping("/catalog/series/{genre}")
    public List<Serie> getSerieByGenre(@PathVariable String genre) {
        return iSerieClient.getSerieByGenre(genre);
    }
    @PostMapping("/catalog/series")
    public String createSerie(@RequestBody Serie serie) {
        return iSerieClient.create(serie);
    }
}

