package com.amarnath.movie.controller;

import com.amarnath.movie.dto.TrailerDTO;
import com.amarnath.movie.service.TrailerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TrailerController {

    private final TrailerService trailerService;

    @Autowired
    public TrailerController(TrailerService trailerService) {
        this.trailerService = trailerService;
    }

    @PostMapping("/api/v1/movies/{movieId}/trailer")
    private ResponseEntity<TrailerDTO> addTrailerToMovie(@PathVariable long movieId, @RequestBody TrailerDTO trailerDTO){

        return new ResponseEntity<>(trailerService.saveTrailersByMovie(movieId, trailerDTO), HttpStatus.CREATED);

    }

    @GetMapping("/api/v1/movies/{movieId}/trailer")
    private ResponseEntity<List<TrailerDTO>> getAllTrailersByMovie(@PathVariable long movieId){

        return new ResponseEntity<>(trailerService.getAllTrailerByMovie(movieId), HttpStatus.OK);

    }

    @DeleteMapping("/api/v1/movies/{movieId}/trailer/{trailerId}")
    private ResponseEntity<String> deleteTrailerById(@PathVariable long movieId,
                                                     @PathVariable long trailerId){

        return new ResponseEntity<>(trailerService.deleteTrailerByMovie(movieId, trailerId), HttpStatus.OK);

    }


}
