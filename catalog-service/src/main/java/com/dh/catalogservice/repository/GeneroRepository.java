package com.dh.catalogservice.repository;

import com.dh.catalogservice.model.Genero;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GeneroRepository extends MongoRepository<Genero, Long> {
    Genero findByName(String name);
}
