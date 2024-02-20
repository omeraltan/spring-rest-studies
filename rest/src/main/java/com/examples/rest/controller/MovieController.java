package com.examples.rest.controller;

import com.examples.rest.entity.Movie;
import com.examples.rest.entity.Star;
import com.examples.rest.service.MovieService;
import com.examples.rest.service.StarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;

@Controller
public class MovieController {

    @Autowired
    MovieService service;
    @Autowired
    StarService starService;

    @GetMapping("/movies") // http://localhost:8080/movies
    @ResponseBody
    public List<Movie> getAllMovies(){
        return service.findAll();
    }

    @GetMapping("/movies/{movieId}")
    @ResponseBody
    public Optional<Movie> getMoviesById(@PathVariable Long movieId){
        return service.findById(movieId);
    }

    @GetMapping("/movies/{movieId}/stars")
    @ResponseBody
    public Optional<Star> getMovieStars(@PathVariable Long movieId){
        return starService.findMovieStars(movieId);
    }

    @GetMapping("/movies/{movieId}/stars/{starsId}") // http://localhost:8080/movies/1/stars/1
    @ResponseBody
    public Optional<Star> getMoviesAndStars(@PathVariable Long movieId, @PathVariable Long starsId){
        return starService.findByIdAndMovie(movieId,starsId);
    }

    @GetMapping("/movies/search")
    @ResponseBody
    public Optional<Movie> getMovie(@RequestParam(value = "id", required = false) Long id,
                                    @RequestParam(value = "name", required = false) String name,
                                    @RequestParam(value = "country", required = false) String country,
                                    @RequestParam(value = "year", required = false) String year,
                                    @RequestParam(value = "director", required = false) String director) {
        if (name != null && name != ""){
            return service.findByName(name);
        }
        else if (id != null){
            return service.findById(id);
        }
        else {
            return service.findById(id);
        }
    }


}
