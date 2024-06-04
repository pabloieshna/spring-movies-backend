package com.adorno.service.impl;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adorno.model.Movie;
import com.adorno.repository.MovieRepository;
import com.adorno.service.MovieService;

@Service
public class MovieServiceImpl implements MovieService {

	@Autowired
	private MovieRepository movieRepository;

	@Override
	public List<Movie> allMovies() {

		System.out.println(movieRepository.findAll().size());
		return movieRepository.findAll();
	}

	@Override
	public Optional<Movie> singleMovie(String imbdId) {
		return movieRepository.findMovieByImdbId(imbdId);
	}
}
