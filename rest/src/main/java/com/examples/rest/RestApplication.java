package com.examples.rest;

import com.examples.rest.controller.FoodController;
import com.examples.rest.entity.Book;
import com.examples.rest.entity.Food;
import com.examples.rest.repository.BookRepository;
import com.examples.rest.repository.FoodRepository;
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
    @Autowired
    FoodRepository foodRepository;

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

        Food food1 = new Food(1L, "Bread", 1, 5.12);
        Food food2 = new Food(2L, "Cheese", 2, 12.24);
        Food food3 = new Food(3L, "olive", 2, 7.41);
        Food food4 = new Food(4L, "egg", 2, 2.00);
        Food food5 = new Food(5L, "tomato", 3, 5.00);
        Food food6 = new Food(6L, "cucumber", 3, 7.56);
        Food food7 = new Food(7L, "lettuce", 3, 4.33);
        Food food8 = new Food(8L, "parsley", 3, 3.00);
        Food food9 = new Food(9L, "sausage", 4, 12.00);
        Food food10 = new Food(10L, "bacon", 4, 24.00);

        List<Food> foodList = Arrays.asList(food1,food2,food3,food4,food5,food6,food7,food8,food9,food10);
        foodRepository.saveAll(foodList);

    }
}
