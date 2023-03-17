package com.movie.reviews.movieapi.repository;

import com.movie.reviews.movieapi.model.Movie;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository //responsible for data access layer & actually talks to the db and retrieving the data
public interface MovieRepository extends MongoRepository<Movie, ObjectId> {


}
