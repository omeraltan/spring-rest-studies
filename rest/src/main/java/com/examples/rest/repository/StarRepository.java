package com.examples.rest.repository;

import com.examples.rest.entity.Star;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface StarRepository extends JpaRepository<Star, Long> {

    @Query("SELECT u FROM Star u WHERE u.movie_id = :movie_id")
    Optional<Star> findMovieStars(@Param("movie_id") Long movie_id);

    @Query("SELECT u FROM Star u WHERE u.id = :id AND u.movie_id = :movie_id")
    Optional<Star> findByIdAndMovie(@Param("movie_id") Long movie_id, @Param("id") Long id);

}
