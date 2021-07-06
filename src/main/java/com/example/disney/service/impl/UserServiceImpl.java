package com.example.disney.service.impl;


import com.example.disney.commons.GenericServiceImpl;
import com.example.disney.dao.api.UserDaoAPI;
import com.example.disney.model.User;
import com.example.disney.service.api.UserServiceAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl extends GenericServiceImpl<User, Long> implements UserServiceAPI {

    @Autowired
    private UserDaoAPI userDaoAPI;

    @Override
    public CrudRepository<User, Long> getDao() {return userDaoAPI;}



}
