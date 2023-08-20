package com.amarnath.movie.service;

import com.amarnath.movie.dto.RateDTO;

public interface RatingService {

    RateDTO updateRatingByMovieById(long movieId, long ratingId, RateDTO rating);

    RateDTO getRatingByMovieId(long movieId);

    RateDTO createRatingByMovieById(long movieId, RateDTO rating);


}
