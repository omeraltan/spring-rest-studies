package com.examples.rest.service;

import com.examples.rest.entity.Food;

import java.util.List;
import java.util.Optional;

public interface FoodService {
    Optional<Food> findById(Long id);

    Optional<Food> findByIdAndType(Long id, Integer type);

    Optional<Food> save(Food food);

    List<Food> findAll();
}
