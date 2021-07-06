package com.example.disney.dao.api;

import com.example.disney.model.FilmSerie;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface FilmSerieDaoAPI extends CrudRepository<FilmSerie, Long> {

    public List<FilmSerie> findByOrderByDateAsc();

    public List<FilmSerie> findByOrderByDateDesc();
    //@Modifying
    //@Query(value = "SELECT * FROM Personage WHERE Personage.name = :name", nativeQuery = true)
    //SELECT * FROM $table ORDER BY DATE_FORMAT(Date, '%Y%m%d') DESC LIMIT 14
    /*@Modifying
    @Query(value = "SELECT * FROM $date ORDER BY DATE_FORMAT(Date,'%Y%m%d') ASC", nativeQuery = true)
    List<FilmSerie> ordenarAsc();

    @Modifying
    @Query(value = "SELECT * FROM $date ORDER BY DATE_FORMAT(Date,'%Y%m%d') DESC", nativeQuery = true)
    List<FilmSerie> ordenarDesc();

    List<FilmSerie> ordenar(String order);
    findByOrderBy*/
}
