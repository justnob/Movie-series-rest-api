package com.amarnath.movie.controller;

import java.util.List;

import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.amarnath.movie.dto.MovieDTO;
import com.amarnath.movie.service.impl.MovieServiceImpl;

@RestController
public class MovieController {
	
	private final MovieServiceImpl movieServiceImpl;
	
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

	@GetMapping("/api/v1/movies/{id}")
	private ResponseEntity<MovieDTO> getMovieById(@PathVariable int id){

		return new ResponseEntity<>(movieServiceImpl.getMovieById(id), HttpStatus.OK);

	}

	@PutMapping("/api/v1/movies/{id}")
	private ResponseEntity<MovieDTO> updateMovieById(@PathVariable int id, @RequestBody MovieDTO movieDTO){

		return new ResponseEntity<>(movieServiceImpl.updateMovieById(id, movieDTO), HttpStatus.OK);

	}

	@GetMapping("/api/v1/movies/name")
	private ResponseEntity<List<MovieDTO>> getMovieByName(@RequestParam String name){

		return new ResponseEntity<>(movieServiceImpl.getMovieByName(name), HttpStatus.OK);

	}

	@DeleteMapping("/api/v1/movies/{id}")
	private ResponseEntity<String> deleteMovieById(@PathVariable int id){

		return new ResponseEntity<>(movieServiceImpl.deleteMovieById(id), HttpStatus.OK);

	}

}
