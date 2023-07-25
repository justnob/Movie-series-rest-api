package com.amarnath.movie.service.impl;

import com.amarnath.movie.dto.MovieDTO;
import com.amarnath.movie.entity.Movie;
import com.amarnath.movie.errorhandeling.ApplicationException;
import com.amarnath.movie.repository.MovieRepository;
import com.amarnath.movie.repository.RatingRepository;
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

	private final MovieRepository movieRepository;
	private final ModelMapper mapper;

	private final RatingRepository ratingRepository;

	@Autowired
	public MovieServiceImpl(MovieRepository movieRepository, ModelMapper mapper, RatingRepository ratingRepository) {
		super();
		this.movieRepository = movieRepository;
		this.mapper = mapper;
		this.ratingRepository = ratingRepository;
	}

	@Override
	public List<MovieDTO> getAllMovies() {

		List<Movie> movieEntityResponse = movieRepository.findAll();

		return movieEntityResponse.stream().map(this::mapToDto)
				.collect(Collectors.toList());

	}

	@Override
	public MovieDTO createAMovie(MovieDTO movieDTO) {

		Movie reaceavedMovie = mapToEntity(movieDTO);

		Movie savedMovie = movieRepository.save(reaceavedMovie);

		return mapToDto(savedMovie);
	}

	@Override
	public MovieDTO getMovieById(int id) {

		List<Movie> movieEntityResponse = movieRepository.findAll();

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

		List<Movie> movieEntityResponse = movieRepository.findAll();

		Predicate<? super Movie> predicate = (movie -> movie.getId() == id);
		Movie movieById = movieEntityResponse.stream().filter(predicate).findFirst().orElseThrow(() ->
				new ApplicationException(
						"Movie-Or-Series-Not-Found",
						String.format("Can't find movie or series with id=%d", id),
						HttpStatus.NOT_FOUND
				));

		movieById.setName(movieDTO.getName());
		movieById.setDescription(movieDTO.getDescription());
		movieById.setImageUrl(movieDTO.getImageUrl());
		movieById.setNumberOfEpisodes(movieDTO.getNumberOfEpisodes());
		movieById.setAirDate(movieDTO.getAirDate());
		movieById.setEndDate(movieDTO.getEndDate());
		movieById.setRating(ratingRepository.save(movieDTO.getRating()));

		Movie savedResponse = movieRepository.save(movieById);

		return mapToDto(savedResponse);

	}

	@Override
	public List<MovieDTO> getMovieByName(String name) {

		List<Movie> movieEntityResponse = movieRepository.findAll();

		Predicate<? super Movie> predicate = (movie -> movie.getName().contains(name.toLowerCase()));
		List<Movie> collect = movieEntityResponse.stream().filter(predicate).toList();

		List<MovieDTO> movieDTOStream = collect.stream().map(this::mapToDto).collect(Collectors.toList());

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

		List<Movie> movieEntityResponse = movieRepository.findAll();

		Predicate<? super Movie> predicate = (movie -> movie.getId() == id);
		Movie movieById = movieEntityResponse.stream().filter(predicate).findFirst().orElseThrow(() ->
				new ApplicationException(
						"Movie-Or-Series-Not-Found",
						String.format("Can't find movie or series with id=%d", id),
						HttpStatus.NOT_FOUND
				));

		movieRepository.delete(movieById);

		return "The Movie or Series has been deleted!";
	}

	private MovieDTO mapToDto(Movie movie) {

		return mapper.map(movie, MovieDTO.class);

	}

	private Movie mapToEntity(MovieDTO movieDto) {

		return mapper.map(movieDto, Movie.class);

	}

}
