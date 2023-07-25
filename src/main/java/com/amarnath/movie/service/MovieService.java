package com.amarnath.movie.service;

import java.util.List;

import com.amarnath.movie.dto.MovieDTO;
import com.amarnath.movie.entity.Movie;

public interface MovieService {
	
	List<MovieDTO> getAllMovies();

	MovieDTO createAMovie(MovieDTO movieDto);

	MovieDTO getMovieById(int id);

	MovieDTO updateMovieById(int id, MovieDTO movieDTO);

	List<MovieDTO> getMovieByName(String name);

	String deleteMovieById(int id);

}
