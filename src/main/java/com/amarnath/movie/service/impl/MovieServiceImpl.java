package com.amarnath.movie.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amarnath.movie.dto.MovieDTO;
import com.amarnath.movie.entity.Movie;
import com.amarnath.movie.repository.MovieRepostory;
import com.amarnath.movie.service.MovieService;

@Service
public class MovieServiceImpl implements MovieService {

	private MovieRepostory movieRepostory;
	private ModelMapper mapper;

	@Autowired
	public MovieServiceImpl(MovieRepostory movieRepostory, ModelMapper mapper) {
		super();
		this.movieRepostory = movieRepostory;
		this.mapper = mapper;
	}

	@Override
	public List<MovieDTO> getAllMovies() {

		List<Movie> movieEntityResponse = movieRepostory.findAll();

		List<MovieDTO> movieDtoResponse = movieEntityResponse.stream().map(movie -> mapToDto(movie))
				.collect(Collectors.toList());

		return movieDtoResponse;

	}

	@Override
	public MovieDTO createAMovie(MovieDTO movieDTO) {

		Movie reaceavedMove = mapToEntity(movieDTO);

		Movie savedMovie = movieRepostory.save(reaceavedMove);

		MovieDTO responseOfSavedMovie = mapToDto(savedMovie);

		return responseOfSavedMovie;
	}

	private MovieDTO mapToDto(Movie movie) {

		 MovieDTO movieDTO = mapper.map(movie, MovieDTO.class);
		 
		 return movieDTO;

	}

	private Movie mapToEntity(MovieDTO movieDto) {

		return mapper.map(movieDto, Movie.class);

	}

}
