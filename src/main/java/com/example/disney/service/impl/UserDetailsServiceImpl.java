package com.example.disney.service.impl;


import com.example.disney.dao.api.UserDaoAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserDaoAPI userDaoAPI;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        com.example.disney.model.User appUser = userDaoAPI.findByUserName(username).orElseThrow(() -> new UsernameNotFoundException("Login Username Invalido."));

        Set<GrantedAuthority> grantList = new HashSet<GrantedAuthority>();
        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("USER_ROLE");
        grantList.add(grantedAuthority);


        //se necesita si o si un roll(incluso si no se usa para nada)
        UserDetails user = (UserDetails) new User(username,appUser.getPassword(),grantList);
        return user;
    }

}
