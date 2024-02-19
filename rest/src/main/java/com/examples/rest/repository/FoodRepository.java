package com.examples.rest.repository;

import com.examples.rest.entity.Food;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FoodRepository extends JpaRepository<Food, Long> {

    Optional<Food> findByIdAndType(Long id, Integer type);

}
