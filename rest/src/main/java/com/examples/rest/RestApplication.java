package com.examples.rest;

import com.examples.rest.entity.Book;
import com.examples.rest.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class RestApplication implements CommandLineRunner {

    @Autowired
    BookRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(RestApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Book book1 = new Book(1L,"The House Of Mirth", 1);
        Book book2 = new Book(2L,"East Of Eden", 2);
        Book book3 = new Book(3L,"The Sun Also Rises", 1);
        Book book4 = new Book(4L,"Vile Bodies", 1);
        Book book5 = new Book(5L,"A scanner Darkly", 3);
        Book book6 = new Book(6L,"Number The Stars", 2);
        Book book7 = new Book(7L,"Noli Me Tangere", 3);
        Book book8 = new Book(8L,"Brave New World", 2);
        Book book9 = new Book(9L,"Rosemary And Rue", 1);

        List<Book> bookList = Arrays.asList(book1,book2,book3,book4,book5,book6,book7,book8,book9);
        repository.saveAll(bookList);
    }
}
