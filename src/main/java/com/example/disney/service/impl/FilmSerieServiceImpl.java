package com.example.disney.service.impl;

import com.example.disney.commons.GenericServiceImpl;
import com.example.disney.dao.api.FilmSerieDaoAPI;
import com.example.disney.model.FilmSerie;
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

}
