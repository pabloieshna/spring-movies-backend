package com.adorno.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.adorno.model.Review;

@Repository
public interface ReviewRepository extends MongoRepository<Review, String> {
	List<Review> findByUser(String userId);

	List<Review> findByMovieId(String movieId);
	Optional<Review> findByUserAndMovie(String user, String movie);
}
