package com.adorno.service;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;

import com.adorno.model.Movie;

public interface MovieService {

	public List<Movie> allMovies();
	public Optional<Movie> singleMovie(String imdbId);
}
