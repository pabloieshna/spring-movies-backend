package com.adorno.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adorno.model.Movie;
import com.adorno.model.Review;
import com.adorno.repository.MovieRepository;
import com.adorno.repository.ReviewRepository;
import com.adorno.service.ReviewService;

@Service
public class ReviewServiceImpl implements ReviewService {

	@Autowired
	private ReviewRepository reviewRepository;

	@Autowired
	private MovieRepository movieRepository;

	@Override
	public Review addReview(Review review) {
		// Verificar si la película existe en el repositorio antes de guardar la review
		if (review.getMovie() != null) {
			Optional<Movie> movie = movieRepository.findById(review.getMovie().getId());
			if (movie.isPresent()) {
				review.setMovie(movie.get());
				review.setUser(review.getUser());
				return reviewRepository.save(review);
			} else {
				throw new RuntimeException("Movie not found");
			}
		} else {
			throw new RuntimeException("Review must contain a movie");
		}
	}

	@Override
	public List<Review> getReviewsByUser(String userId) {
		return reviewRepository.findByUser(userId);
	}

	@Override
	public List<Review> getReviewsByMovie(String movieId) {
		return reviewRepository.findByMovieId(movieId);
	}

	@Override
	public Review getReviewByUserAndMovie(String userId, String movieId) {
		return reviewRepository.findByUserAndMovie(userId, movieId)
				.orElseThrow(() -> new RuntimeException("Review not found"));
	}

	@Override
	public Review updateReview(String id, Review reviewDetails) {
		// Verificar si la película existe
		Optional<Movie> movieOptional = movieRepository.findById(reviewDetails.getMovie().getId());
		if (movieOptional.isEmpty()) {
			throw new ExceptionInInitializerError("La película no existe.");
		}

		// Obtener la reseña por su ID
		Optional<Review> existingReviewOptional = reviewRepository.findById(id);
		if (existingReviewOptional.isEmpty()) {
			throw new ExceptionInInitializerError("La reseña no existe.");
		}

		// Actualizar los detalles de la reseña
		Review existingReview = existingReviewOptional.get();
		existingReview.setRating(reviewDetails.getRating());
		existingReview.setComment(reviewDetails.getComment());

		// Guardar la reseña actualizada
		return reviewRepository.save(existingReview);
	}

	@Override
	public void deleteReview(String id) {
		reviewRepository.deleteById(id);
	}
}
