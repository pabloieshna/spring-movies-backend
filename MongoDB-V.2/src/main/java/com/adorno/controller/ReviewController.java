package com.adorno.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adorno.model.Review;
import com.adorno.service.impl.ReviewServiceImpl;

@RestController
@RequestMapping("/api/v1/reviews")
@CrossOrigin(origins = "http://localhost:4200")
public class ReviewController {

    @Autowired
    private ReviewServiceImpl reviewServiceImpl;

    @PostMapping
    public ResponseEntity<Review> addReview(@RequestBody Review review) {
        return new ResponseEntity<>(reviewServiceImpl.addReview(review), HttpStatus.CREATED);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Review>> getReviewsByUser(@PathVariable String userId) {
        return new ResponseEntity<>(reviewServiceImpl.getReviewsByUser(userId), HttpStatus.OK);
    }

    @GetMapping("/movie/{movieId}")
    public ResponseEntity<List<Review>> getReviewsByMovie(@PathVariable String movieId) {
        return new ResponseEntity<>(reviewServiceImpl.getReviewsByMovie(movieId), HttpStatus.OK);
    }

    @GetMapping("/user/{userId}/movie/{movieId}")
    public ResponseEntity<Review> getReviewByUserAndMovie(@PathVariable String userId, @PathVariable String movieId) {
        return new ResponseEntity<>(reviewServiceImpl.getReviewByUserAndMovie(userId, movieId), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Review> updateReview(@PathVariable String id, @RequestBody Review reviewDetails) {
        return new ResponseEntity<>(reviewServiceImpl.updateReview(id, reviewDetails), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReview(@PathVariable String id) {
    	reviewServiceImpl.deleteReview(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
