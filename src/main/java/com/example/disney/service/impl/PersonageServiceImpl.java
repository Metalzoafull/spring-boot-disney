package com.example.disney.service.impl;

import com.example.disney.commons.GenericServiceImpl;

import com.example.disney.dao.api.PersonageDaoAPI;
import com.example.disney.model.Personage;

import com.example.disney.service.api.PersonageServiceAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;



@Service
public class PersonageServiceImpl extends GenericServiceImpl<Personage, Long> implements PersonageServiceAPI {

    @Autowired
    private PersonageDaoAPI personageDaoAPI;

    @Override
    public CrudRepository<Personage, Long> getDao() {
        return personageDaoAPI;
    }
}
