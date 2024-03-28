package com.dh.movieservice.controller;

import com.dh.movieservice.model.Movie;
import com.dh.movieservice.queue.MovieSender;
import com.dh.movieservice.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/movies")
public class MovieController {
    private final MovieService movieService;
    private final Environment environment;
    private final MovieSender movieSender;

//    @Autowired
//    public MovieController(MovieService movieService, Environment environment, MovieSender movieSender) {
//        this.movieService = movieService;
//        this.environment = environment;
//        this.movieSender = movieSender;
//    }

    @GetMapping("/{genre}")
    ResponseEntity<List<Movie>> getMovieByGenre(@PathVariable String genre) {
        List<Movie> movies = movieService.findByGenre(genre);
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Port", environment.getProperty("local.server.port"));

        return ResponseEntity.ok().headers(responseHeaders).body(movies);
    }

    @PostMapping("/save")
    ResponseEntity<Movie> saveMovie(@RequestBody Movie movie) {
        Movie savedMovie = movieService.save(movie);
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Port", environment.getProperty("local.server.port"));
        movieSender.send(movie);

        return ResponseEntity.ok().headers(responseHeaders).body(savedMovie);
    }
}
