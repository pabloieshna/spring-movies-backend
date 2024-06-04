package com.adorno.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.adorno.model.Movie;

@Repository
public interface MovieRepository extends MongoRepository<Movie, String> {

	Optional<Movie> findMovieByImdbId(String imbdId);
	Optional<Movie> findById(String id);
}
