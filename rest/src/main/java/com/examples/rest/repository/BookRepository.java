package com.examples.rest.repository;

import com.examples.rest.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {

    Optional<Book> findById(Long id);
    Optional<Book> findByIdAndName(Long Id, String name);

    Optional<Book> findAllByIdIn(List<Long> id);
}
