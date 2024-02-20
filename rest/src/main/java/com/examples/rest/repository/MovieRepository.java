package com.examples.rest.repository;

import com.examples.rest.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    Optional<Movie> findById(Long id);

    Optional<Movie> findByName(String name);
    Optional<Movie> findAllByCountry(String name);

}
