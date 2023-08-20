package com.amarnath.movie.controller;

import com.amarnath.movie.dto.RateDTO;
import com.amarnath.movie.service.RatingService;
import com.amarnath.movie.service.impl.RatingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class RatingController {

    private final RatingService ratingService;

    @Autowired
    public RatingController(RatingService ratingService) {
        this.ratingService = ratingService;
    }

    @PutMapping("/api/v1/movies/{movieId}/rating/{ratingId}")
    private ResponseEntity<RateDTO> updateRatingByMovieById(@PathVariable long movieId,
                                                            @PathVariable long ratingId,
                                                            @RequestBody RateDTO rating)
    {

        return new ResponseEntity<>(ratingService.updateRatingByMovieById(movieId, ratingId, rating),
                HttpStatus.OK);

    }

    @GetMapping("/api/v1/movies/{movieId}/rating")
    private ResponseEntity<RateDTO> getRatingByMovieById(
            @PathVariable long movieId
    ){

        return new ResponseEntity<>(ratingService.getRatingByMovieId(movieId), HttpStatus.OK);

    }

    @PostMapping("/api/v1/movies/{movieId}/rating")
    private ResponseEntity<RateDTO> createRatingByMovieById(@PathVariable long movieId,
                                                            @RequestBody RateDTO rating)
    {

        return new ResponseEntity<>(ratingService.createRatingByMovieById(movieId, rating),
                HttpStatus.OK);

    }

}
