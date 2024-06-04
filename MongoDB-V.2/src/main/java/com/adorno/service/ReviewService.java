package com.adorno.service;

import com.adorno.model.Review;
import java.util.List;

public interface ReviewService {
    Review addReview(Review review);
    List<Review> getReviewsByUser(String userId);
    List<Review> getReviewsByMovie(String movieId);
    Review getReviewByUserAndMovie(String userId, String movieId);
    Review updateReview(String id, Review reviewDetails);
    void deleteReview(String id);
}
