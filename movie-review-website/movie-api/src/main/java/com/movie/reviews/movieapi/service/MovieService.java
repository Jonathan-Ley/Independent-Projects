package com.movie.reviews.movieapi.service;

import com.movie.reviews.movieapi.model.Movie;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MovieService {

    List<Movie> getAllMovies();
}
