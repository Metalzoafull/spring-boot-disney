package com.example.disney.dao.api;

import com.example.disney.model.FilmSerie;
import org.springframework.data.repository.CrudRepository;

public interface FilmSerieDaoAPI extends CrudRepository<FilmSerie, Long> {
}
