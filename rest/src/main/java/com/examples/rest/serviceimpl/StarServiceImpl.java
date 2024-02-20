package com.examples.rest.serviceimpl;

import com.examples.rest.entity.Star;
import com.examples.rest.repository.StarRepository;
import com.examples.rest.service.StarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StarServiceImpl implements StarService {
    @Autowired
    StarRepository repository;
    @Override
    public Optional<Star> findMovieStars(Long id) {
        return repository.findMovieStars(id);
    }

    @Override
    public Optional<Star> findByIdAndMovie(Long id, Long movie_id) {
        return repository.findByIdAndMovie(id,movie_id);
    }
}
