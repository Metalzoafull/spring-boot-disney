package com.example.disney.dao.api;

import com.example.disney.model.Personage;
import org.springframework.data.repository.CrudRepository;

public interface PersonageDaoAPI extends CrudRepository<Personage, Long> {
}
