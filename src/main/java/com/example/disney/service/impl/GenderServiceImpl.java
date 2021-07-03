package com.example.disney.service.impl;

import com.example.disney.commons.GenericServiceImpl;
import com.example.disney.dao.api.GenderDaoAPI;
import com.example.disney.model.Gender;
import com.example.disney.service.api.GenderServiceAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;

public class GenderServiceImpl extends GenericServiceImpl<Gender, Long> implements GenderServiceAPI {

    @Autowired
    private GenderDaoAPI genderDaoAPI;

    @Override
    public CrudRepository<Gender, Long> getDao() {return genderDaoAPI;}


}
