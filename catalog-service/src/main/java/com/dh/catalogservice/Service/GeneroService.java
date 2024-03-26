package com.dh.catalogservice.Service;

import com.dh.catalogservice.model.Genero;
import com.dh.catalogservice.model.Serie;
import com.dh.catalogservice.repository.GeneroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        //Si no existe el genero lo creo y agrego la serie
        Genero genero = repository.findByName(serie.genre());
        if (genero == null) {
            Genero newgenero = new Genero();
            newgenero.setName(serie.genre());
            newgenero.addSerie(serie);
            repository.save(newgenero);
        }else {
            //Si existe el genero, agrego la serie
            genero.addSerie(serie);
            repository.save(genero);

        }

        return serie.id();
    }
    //TODO Implementar el metodo para guardar una Movie

}
