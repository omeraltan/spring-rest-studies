package com.examples.rest.service;

import com.examples.rest.entity.Star;

import java.util.Optional;

public interface StarService {

    Optional<Star> findMovieStars(Long id);
    Optional<Star> findByIdAndMovie(Long id, Long movie_id);

}
