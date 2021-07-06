package com.example.disney.service.impl;

import com.example.disney.commons.GenericServiceImpl;

import com.example.disney.dao.api.PersonageDaoAPI;
import com.example.disney.model.FilmSerie;
import com.example.disney.model.Personage;

import com.example.disney.service.api.PersonageServiceAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;


@Service
public class PersonageServiceImpl extends GenericServiceImpl<Personage, Long> implements PersonageServiceAPI {

    @Autowired
    private PersonageDaoAPI personageDaoAPI;

    @Override
    public CrudRepository<Personage, Long> getDao() {
        return personageDaoAPI;
    }

    @Override
    public List<Personage> filterAge(Long age){
        List<Personage> listAge = getAll().stream().filter(p -> p.getAge() == age).collect(Collectors.toList());
        return listAge;

    }

    @Override
    public List<Personage> filterFilmS(Long id){
        List<Personage> listP;//filter(f ->
        List<Personage> list = new ArrayList<>();
        for (Personage personage : getAll()) {
            Set<FilmSerie> f = personage.getFilmSerie();
            if (f.stream().anyMatch(fi -> fi.getId().equals(id))) {
                list.add(personage);
            }
        }
        listP = list;
        return listP;
                /*{
            Object list = new ArrayList<>();
            for (FilmSerie fi : f) {
                if (fi.getId().equals(id)) {
                    list.add(fi);
                }
            }
            return list;
        });*/
    }

    /*public Optional<Personage> buscar(String name){
        return personageDaoAPI.buscar(name);
    }*/

    @Override
    public Optional<Personage> findByName(String name) {
        return personageDaoAPI.findByname(name);
    }
}
