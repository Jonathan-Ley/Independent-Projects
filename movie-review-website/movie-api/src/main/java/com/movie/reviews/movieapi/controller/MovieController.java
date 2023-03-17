package com.movie.reviews.movieapi.controller;

import com.movie.reviews.movieapi.model.Movie;
import com.movie.reviews.movieapi.service.MovieServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController //responsible for the responses from the user
@RequestMapping("/api/v1/movies")
public class MovieController {

    @Autowired
    private MovieServiceImplementation movieService;

    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies() {
        return new ResponseEntity<List<Movie>>(movieService.getAllMovies(), HttpStatus.OK);
    }
}
