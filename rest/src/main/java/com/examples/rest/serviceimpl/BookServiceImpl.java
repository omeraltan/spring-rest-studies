package com.examples.rest.serviceimpl;

import com.examples.rest.entity.Book;
import com.examples.rest.repository.BookRepository;
import com.examples.rest.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    BookRepository repository;
    @Override
    public List<Book> findByAllBooks() {
        return repository.findAll();
    }

    @Override
    public Optional<Book> findBookById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Optional<Book> findByIdAndName(Long id, String name) {
        return repository.findByIdAndName(id, name);
    }

    @Override
    public Optional<Book> findAllByIdIn(List<Long> id) {
        return repository.findAllByIdIn(id);
    }
}
