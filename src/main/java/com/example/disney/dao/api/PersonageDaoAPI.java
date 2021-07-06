package com.example.disney.dao.api;

import com.example.disney.model.Personage;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PersonageDaoAPI extends CrudRepository<Personage, Long> {

    public Optional<Personage> findByname(String name);

    //@Modifying
    //@Query(value = "SELECT * FROM Personage WHERE Personage.name = :name", nativeQuery = true)
    //Optional<Personage> buscar(String name);

}
