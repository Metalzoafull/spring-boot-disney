package com.example.disney.dao.api;

import com.example.disney.model.Gender;
import org.springframework.data.repository.CrudRepository;

public interface GenderDaoAPI extends CrudRepository<Gender, Long> {
}
