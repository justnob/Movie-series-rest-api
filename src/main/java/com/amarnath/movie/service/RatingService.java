package com.amarnath.movie.service;

import com.amarnath.movie.dto.RateDTO;

public interface RatingService {

    RateDTO updateRatingByMovieById(long movieId, long ratingId, RateDTO rating);

    RateDTO getRatingByMovieById(long movieId, long ratingId);

    RateDTO createRatingByMovieById(long movieId, RateDTO rating);


}
