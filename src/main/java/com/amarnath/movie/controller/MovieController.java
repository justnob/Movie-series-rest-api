package com.amarnath.movie.controller;

import java.util.List;

import com.amarnath.movie.entity.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.amarnath.movie.dto.MovieDTO;
import com.amarnath.movie.service.impl.MovieServiceImpl;

@RestController
public class MovieController {
	
	private MovieServiceImpl movieServiceImpl;
	
	@Autowired
	public MovieController(MovieServiceImpl movieServiceImpl) {
		super();
		this.movieServiceImpl = movieServiceImpl;
	}


	@GetMapping("/api/v1/movies")
	private ResponseEntity<List<MovieDTO>> getAllMovies(){
		
		return new ResponseEntity<>(movieServiceImpl.getAllMovies(), HttpStatus.OK);
		
	}

	@PostMapping("/api/v1/movies")
	private ResponseEntity<MovieDTO> createNewMovie(@RequestBody MovieDTO movieDto){

		return new ResponseEntity<>(movieServiceImpl.createAMovie(movieDto), HttpStatus.CREATED);

	}

}
