package com.examples.rest.service;

import com.examples.rest.entity.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {

    List<Book> findByAllBooks();
    Optional<Book> findBookById(Long id);
    Optional<Book> findByIdAndName(Long id, String name);
    Optional<Book> findAllByIdIn(List<Long> id);
}
