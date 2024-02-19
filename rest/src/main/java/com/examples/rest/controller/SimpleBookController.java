package com.examples.rest.controller;

import com.examples.rest.entity.Book;
import com.examples.rest.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("books")
public class SimpleBookController {
    @Autowired
    BookService service;

    @GetMapping()
    public @ResponseBody List<Book> getAllBook(){
        return service.findByAllBooks();
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public @ResponseBody Optional<Book> getBookId(@PathVariable Long id){
        return service.findBookById(id);
    }
}
@RestController
@RequestMapping("books-rest")
class SimpleBookController2{

    @Autowired
    BookService service;

    @GetMapping(value = "/{id}", produces = "application/json")
    public Optional<Book> getBook(@PathVariable Long id){
        return service.findBookById(id);
    }

}
