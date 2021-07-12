package com.example.disney.service.impl;

import com.example.disney.commons.GenericServiceImpl;
import com.example.disney.dao.api.FilmSerieDaoAPI;
import com.example.disney.model.FilmSerie;
import com.example.disney.model.Gender;
import com.example.disney.model.Personage;
import com.example.disney.service.api.FilmSerieServiceAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class FilmSerieServiceImpl extends GenericServiceImpl<FilmSerie, Long> implements FilmSerieServiceAPI{

    @Autowired
    private FilmSerieDaoAPI filmSerieDaoAPI;

    @Override
    public CrudRepository<FilmSerie, Long> getDao() {return filmSerieDaoAPI;}

    @Override
    public List<FilmSerie> findByOrderByDateAsc() {
        return filmSerieDaoAPI.findByOrderByDateAsc();
    }

    @Override
    public List<FilmSerie> findByOrderByDateDesc() {
        return filmSerieDaoAPI.findByOrderByDateAsc();
    }

    @Override
    public List<FilmSerie> ordenar(String order){
        if (order.equals("ASC")){
            return filmSerieDaoAPI.findByOrderByDateAsc();
        }else{
            return filmSerieDaoAPI.findByOrderByDateDesc();
        }
    }

    @Override
    public List<FilmSerie> filterGender(Long id) {
        List<FilmSerie> listF;//filter(f ->
        List<FilmSerie> list = new ArrayList<>();
        for (FilmSerie filmSerie : getAll()) {
            Set<Gender> g = filmSerie.getGenders();
            if (g.stream().anyMatch(ge -> ge.getId().equals(id))) {
                list.add(filmSerie);
            }
        }
        listF = list;
        return listF;
        }



}


    /*@Override
    public List<FilmSerie> ordenarAsc() {
        return filmSerieDaoAPI.ordenarAsc();
    }

    @Override
    public List<FilmSerie> ordenarDesc() {
        return filmSerieDaoAPI.ordenarDesc();
    }

    @Override
    public List<FilmSerie> ordenar(String order){
        List<FilmSerie> ordenada = null;
        if (order == "ASC"){
            ordenada = filmSerieDaoAPI.ordenarAsc();
        }else if(order == "DESC") {
            ordenada = filmSerieDaoAPI.ordenarDesc();
        }
        return ordenada;
    };*/

