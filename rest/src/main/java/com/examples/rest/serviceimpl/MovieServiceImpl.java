package com.examples.rest.serviceimpl;

import com.examples.rest.entity.Movie;
import com.examples.rest.repository.MovieRepository;
import com.examples.rest.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService {
    @Autowired
    MovieRepository repository;
    @Override
    public List<Movie> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Movie> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Optional<Movie> findByName(String name) {
        return repository.findByName(name);
    }

}
