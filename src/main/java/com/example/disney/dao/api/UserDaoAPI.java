package com.example.disney.dao.api;

import com.example.disney.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserDaoAPI extends CrudRepository<User, Long> {

    public Optional<User> findByName(String username);
}
