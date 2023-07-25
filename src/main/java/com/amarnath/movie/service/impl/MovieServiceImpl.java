package com.amarnath.movie.service.impl;

import com.amarnath.movie.dto.MovieDTO;
import com.amarnath.movie.entity.Movie;
import com.amarnath.movie.errorhandeling.ApplicationException;
import com.amarnath.movie.repository.MovieRepository;
import com.amarnath.movie.service.MovieService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class MovieServiceImpl implements MovieService {

	private final MovieRepository movieRepostory;
	private final ModelMapper mapper;

	@Autowired
	public MovieServiceImpl(MovieRepository movieRepostory, ModelMapper mapper) {
		super();
		this.movieRepostory = movieRepostory;
		this.mapper = mapper;
	}

	@Override
	public List<MovieDTO> getAllMovies() {

		List<Movie> movieEntityResponse = movieRepostory.findAll();

		return movieEntityResponse.stream().map(movie -> mapToDto(movie))
				.collect(Collectors.toList());

	}

	@Override
	public MovieDTO createAMovie(MovieDTO movieDTO) {

		Movie reaceavedMovie = mapToEntity(movieDTO);

		Movie savedMovie = movieRepostory.save(reaceavedMovie);

		return mapToDto(savedMovie);
	}

	@Override
	public MovieDTO getMovieById(int id) {

		List<Movie> movieEntityResponse = movieRepostory.findAll();

		Predicate<? super Movie> predicate = (movie -> movie.getId() == id);
		Movie movieById = movieEntityResponse.stream().filter(predicate).findFirst().orElseThrow(() ->
				new ApplicationException(
						"Movie-Or-Series-Not-Found",
						String.format("Can't find movie or series with id=%d", id),
						HttpStatus.NOT_FOUND
				));

		return mapToDto(movieById);

	}

	@Override
	public MovieDTO updateMovieById(int id, MovieDTO movieDTO) {

		List<Movie> movieEntityResponse = movieRepostory.findAll();

		Predicate<? super Movie> predicate = (movie -> movie.getId() == id);
		Movie movieById = movieEntityResponse.stream().filter(predicate).findFirst().orElseThrow(() ->
				new ApplicationException(
						"Movie-Or-Series-Not-Found",
						String.format("Can't find movie or series with id=%d", id),
						HttpStatus.NOT_FOUND
				));

		movieById.setName(movieDTO.getName());
		movieById.setDescription(movieDTO.getDescription());
		movieById.setRating(movieDTO.getRating());
		movieById.setImageUrl(movieDTO.getImageUrl());
		movieById.setNumberOfEpisodes(movieDTO.getNumberOfEpisodes());
		movieById.setAirDate(movieDTO.getAirDate());
		movieById.setEndDate(movieDTO.getEndDate());

		Movie savedResponse = movieRepostory.save(movieById);

		return mapToDto(savedResponse);

	}

	@Override
	public List<MovieDTO> getMovieByName(String name) {

		List<Movie> movieEntityResponse = movieRepostory.findAll();

		Predicate<? super Movie> predicate = (movie -> movie.getName().contains(name.toLowerCase()));
		List<Movie> collect = movieEntityResponse.stream().filter(predicate).collect(Collectors.toList());

		List<MovieDTO> movieDTOStream = collect.stream().map(movie -> mapToDto(movie)).collect(Collectors.toList());

		if(movieDTOStream.isEmpty()){

			throw new ApplicationException(
					"Movie-Or-Series-Not-Found",
					String.format("%d result found with this name", 0),
					HttpStatus.NOT_FOUND
			);

		}

		return movieDTOStream;
	}

	@Override
	public String deleteMovieById(int id) {

		List<Movie> movieEntityResponse = movieRepostory.findAll();

		Predicate<? super Movie> predicate = (movie -> movie.getId() == id);
		Movie movieById = movieEntityResponse.stream().filter(predicate).findFirst().orElseThrow(() ->
				new ApplicationException(
						"Movie-Or-Series-Not-Found",
						String.format("Can't find movie or series with id=%d", id),
						HttpStatus.NOT_FOUND
				));

		movieRepostory.delete(movieById);

		return "The Movie or Series has been deleted!";
	}

	private MovieDTO mapToDto(Movie movie) {

		return mapper.map(movie, MovieDTO.class);

	}

	private Movie mapToEntity(MovieDTO movieDto) {

		return mapper.map(movieDto, Movie.class);

	}

}
