package com.examples.rest.controller;

import com.examples.rest.entity.Book;
import com.examples.rest.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class BookController {

    @Autowired
    BookService service;

    @GetMapping("/api/books/{id}")
    @ResponseBody
    public String getBooksById(@PathVariable Long id){
        return "ID: " + id;
    }

    @GetMapping("/api/bookswithvariable/{id}") // http://localhost:8080/api/bookswithvariable/1
    @ResponseBody
    public String getBooksByIdWithVariableName(@PathVariable("id") String bookId){
        return "ID: " + bookId;
    }

    @GetMapping("/api/books/{id}/{name}") // http://localhost:8080/api/books/1/ömer
    @ResponseBody
    public String getBooksByIdAndName(@PathVariable("id") String id, @PathVariable String name){
        return "ID: " + id + ", name: " + name;
    }

    @GetMapping("/api/newbooks/{id}/{name}") // http://localhost:8080/api/newbooks/1/ömer
    @ResponseBody
    public String getBooksByIdAndNameWithMapVariable(@PathVariable Map<String, String> pathVarsMap){
        String id = pathVarsMap.get("id");
        String name = pathVarsMap.get("name");
        if (id != null && name != null){
            return "ID: " + id + ", name: " + name;
        }else {
            return "Missing Parameters";
        }
    }

    @GetMapping(value = {"/api/bookswithrequired","/api/bookswithrequired/{id}"})
    @ResponseBody
    public String getBooksByIdWithRequired(@PathVariable(required = false) String id){
        return "ID : " + id;
    }

    @GetMapping(value = {"/api/bookswithroptional","/api/bookswithroptional/{id}"})
    @ResponseBody
    public String getBooksByIdWithOptional(@PathVariable Optional<String> id){
        if (id.isPresent()){
            return "ID: " + id.get();
        }else {
            return "ID missing";
        }
    }

    @GetMapping("/api2/books") // http://localhost:8080/api2/books?id=1
    @ResponseBody
    public Optional<Book> getBooks(@RequestParam Long id){
        return service.findBookById(id);
    }

    @GetMapping("/api2/newbooks") // http://localhost:8080/api2/newbooks?id=9&name=Rosemary And Rue
    @ResponseBody
    public Optional<Book> getBooks2(@RequestParam(name = "id") Long bookId, @RequestParam String name){
        return service.findByIdAndName(bookId, name);
    }

    @GetMapping("/api2/oldbooks") // http://localhost:8080/api2/oldbooks or http://localhost:8080/api2/oldbooks?id=1
    @ResponseBody
    public String getOldBooks(@RequestParam(required = false) Long id){
        return "ID : " + id;
    }

    @GetMapping("/api2/defaultbooks") // http://localhost:8080/api2/defaultbooks
    @ResponseBody
    public Optional<Book> getDefaultBooks(@RequestParam(defaultValue = "9") Long id){
        return service.findBookById(id);
    }

    @GetMapping("/api2/allparamsbooks") // http://localhost:8080/api2/allparamsbooks?id=9&name=Rosemary And Rue
    @ResponseBody
    public Optional<Book> getAllParamsBooks(@RequestParam Map<Long,String> allParams){
        Long id = Long.valueOf(allParams.get("id"));
        String name = allParams.get("name");
        return service.findByIdAndName(id, name);
    }

    @GetMapping("/api2/allparamsin") // http://localhost:8080/api2/allparamsin?id=1&id=2&id=3
    @ResponseBody
    public Optional<Book> getAllParamsInBooks(@RequestParam List<Long> allParams){
        return service.findAllByIdIn(allParams);
    }

}
