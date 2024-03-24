package com.dh.serieservice.controller;

import com.dh.serieservice.model.Serie;
import com.dh.serieservice.queue.SerieSender;
import com.dh.serieservice.service.SerieService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author vaninagodoy
 */

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/series")
public class SerieController {

    private final SerieService serieService;

    private final SerieSender serieSender;

//    public SerieController(SerieService serieService, SerieSender serieSender) {
//        this.serieService = serieService;
//        this.serieSender = serieSender;
//    }

    @GetMapping
    public List<Serie> getAll() {
        return serieService.getAll();
    }

    @GetMapping("/{genre}")
    public List<Serie> getSerieByGenre(@PathVariable String genre) {
        return serieService.getSeriesBygGenre(genre);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String create(@RequestBody Serie serie) {
        serieService.create(serie);
        serieSender.send(serie);
        return serie.getId();
    }
}
