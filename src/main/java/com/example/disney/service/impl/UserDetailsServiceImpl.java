package com.example.disney.service.impl;


import com.example.disney.dao.api.UserDaoAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;



@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserDaoAPI userDaoAPI;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        com.example.disney.model.User appUser = userDaoAPI.findByName(username).orElseThrow(() -> new UsernameNotFoundException("Login Username Invalido."));

        UserDetails user = (UserDetails) new User(username,appUser.getPassword(),null);
        return user;
    }

}
