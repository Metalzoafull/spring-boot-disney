package com.example.disney.service.api;

import com.example.disney.commons.GenericServiceAPI;
import com.example.disney.model.FilmSerie;

import java.util.List;
import java.util.Optional;


public interface FilmSerieServiceAPI extends GenericServiceAPI<FilmSerie, Long> {

    List<FilmSerie> findByOrderByDateAsc();

    List<FilmSerie> findByOrderByDateDesc();

    List<FilmSerie> ordenar(String order);
    /*public List<FilmSerie> ordenarAsc();
    public List<FilmSerie> ordenarDesc();

    public List<FilmSerie> ordenar(String order);*/
}
