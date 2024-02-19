package com.examples.rest.serviceimpl;

import com.examples.rest.entity.Food;
import com.examples.rest.repository.FoodRepository;
import com.examples.rest.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FoodServiceImpl implements FoodService {
    @Autowired
    private FoodRepository repository;
    @Override
    public Optional<Food> findById(Long id) {
        return repository.findById(id);
    }
    @Override
    public Optional<Food> findByIdAndType(Long id, Integer type) {
        return repository.findByIdAndType(id,type);
    }

    @Override
    public Optional<Food> save(Food food) {
        repository.save(food);
        return null;
    }

    @Override
    public List<Food> findAll() {
        return repository.findAll();
    }
}
