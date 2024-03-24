package com.dh.catalogservice.client;

import com.dh.catalogservice.model.Serie;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient (name = "SERIE-SERVICE")
public interface ISerieClient {

    @GetMapping("/api/v1/series")
    List<Serie> getAll();

    @GetMapping("/api/v1/series/{genre}")
    List<Serie> getSerieByGenre(@PathVariable String genre);

    @PostMapping("/api/v1/series")
    String create(@RequestBody Serie serie);
}
