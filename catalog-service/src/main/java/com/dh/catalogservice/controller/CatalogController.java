package com.dh.catalogservice.controller;

import com.dh.catalogservice.client.IMovieClient;
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
}

