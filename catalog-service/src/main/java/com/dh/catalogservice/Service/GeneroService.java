package com.dh.catalogservice.Service;

import com.dh.catalogservice.model.Genero;
import com.dh.catalogservice.model.Movie;
import com.dh.catalogservice.model.Serie;
import com.dh.catalogservice.repository.GeneroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GeneroService {
    //Inyecto el repositorio de genero
    @Autowired
    private GeneroRepository repository;


    // buscar por genero
    public Genero getGeneroByNombre(String nombre) {
        return repository.findByName(nombre);
    }

    //Guardar una serie
    public String saveSerie(Serie serie) {
        Genero genero = repository.findByName(serie.genre());
        if (genero == null) {
            Genero newgenero = new Genero();
            newgenero.setName(serie.genre());
            newgenero.addSerie(serie);
            repository.save(newgenero);
        }else {

            genero.addSerie(serie);
            repository.save(genero);

        }

        return serie.id();    }

    public Long saveMovie(Movie movie) {

        Genero genero = repository.findByName(movie.genre());
        if (genero == null) {
            Genero newgenero = new Genero();
            newgenero.setName(movie.genre());
            newgenero.addMovie(movie);
            repository.save(newgenero);
        }else {

            genero.addMovie(movie);
            repository.save(genero);

        }

        return movie.id();
    }

}
