package com.dh.catalogservice.model;

import jakarta.websocket.server.ServerEndpoint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "Generos")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Genero {

    //EL documento contiene el nombre del genero y 2 listas, una con las peliculas y otra con las series que pertenecen a ese genero
    @Id
    private String id;
    private String name;
    private List<Movie> movies = new ArrayList<>();
    private List<Serie> series = new ArrayList<>();

    public void addSerie(Serie serie) {
        this.series.add(serie);
    }
    public void addMovie(Movie movie) {
        this.movies.add(movie);
    }
}
