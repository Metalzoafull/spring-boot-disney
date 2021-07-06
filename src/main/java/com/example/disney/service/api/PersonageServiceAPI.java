package com.example.disney.service.api;

import com.example.disney.commons.GenericServiceAPI;
import com.example.disney.model.Personage;

import java.util.List;
import java.util.Optional;

public interface PersonageServiceAPI extends GenericServiceAPI<Personage, Long> {

    List<Personage> filterAge(Long age);

    List<Personage> filterFilmS(Long id);

    Optional<Personage> findByName(String name);

    //public Optional<Personage> buscar(String name);
}
