package com.movie.reviews.movieapi.service;

import com.movie.reviews.movieapi.model.Movie;
import com.movie.reviews.movieapi.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service //responsible for the business logic & uses repository to work with the db
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }
}
