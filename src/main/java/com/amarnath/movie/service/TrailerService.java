package com.amarnath.movie.service;

import com.amarnath.movie.dto.TrailerDTO;

import java.util.List;

public interface TrailerService {

    TrailerDTO saveTrailersByMovie(long movieId, TrailerDTO trailerDTO);

    List<TrailerDTO> getAllTrailerByMovie(long movieId);

    String deleteTrailerByMovie(long movieId, long trailerId);

}
