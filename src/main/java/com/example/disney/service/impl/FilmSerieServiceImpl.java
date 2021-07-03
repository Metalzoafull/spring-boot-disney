package com.example.disney.service.impl;

import com.example.disney.commons.GenericServiceImpl;
import com.example.disney.dao.api.FilmSerieDaoAPI;
import com.example.disney.model.FilmSerie;
import com.example.disney.service.api.FilmSerieServiceAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;

public class FilmSerieServiceImpl extends GenericServiceImpl<FilmSerie, Long> implements FilmSerieServiceAPI {

    @Autowired
    private FilmSerieDaoAPI filmSerieDaoAPI;

    @Override
    public CrudRepository<FilmSerie, Long> getDao() {return filmSerieDaoAPI;}

}
