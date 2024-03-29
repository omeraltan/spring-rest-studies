package com.examples.rest.service;

import com.examples.rest.entity.Movie;

import java.util.List;
import java.util.Optional;

public interface MovieService {

    List<Movie> findAll();
    Optional<Movie> findById(Long id);
    Optional<Movie> findByName(String name);

}
