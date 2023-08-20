package com.amarnath.movie.service.impl;

import com.amarnath.movie.dto.TrailerDTO;
import com.amarnath.movie.entity.Movie;
import com.amarnath.movie.entity.Trailer;
import com.amarnath.movie.errorhandeling.ApplicationException;
import com.amarnath.movie.repository.MovieRepository;
import com.amarnath.movie.repository.TrailerRepository;
import com.amarnath.movie.service.TrailerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class TrailerServiceImpl implements TrailerService {

    private final ModelMapper mapper;
    private final TrailerRepository trailerRepository;
    private final MovieRepository movieRepository;

    @Autowired
    public TrailerServiceImpl(ModelMapper mapper, TrailerRepository trailerRepository,
                              MovieRepository movieRepository) {
        this.mapper = mapper;
        this.trailerRepository = trailerRepository;
        this.movieRepository = movieRepository;
    }

    @Override
    public TrailerDTO saveTrailersByMovie(long movieId, TrailerDTO trailerDTO) {

        List<Movie> movieEntityResponse = movieRepository.findAll();

        Predicate<? super Movie> predicate = (movie -> movie.getId() == movieId);
        Movie movieById = movieEntityResponse.stream().filter(predicate).findFirst().orElseThrow(() ->
                new ApplicationException(
                        "Movie-Or-Series-Not-Found",
                        String.format("Can't find movie or series with id=%d", movieId),
                        HttpStatus.NOT_FOUND
                ));

        Trailer trailerEntity = mapToEntity(trailerDTO);

        trailerEntity.setMovie(movieById);

        Trailer savedTrailer = trailerRepository.save(trailerEntity);

        return mapToDTO(savedTrailer);

    }

    @Override
    public List<TrailerDTO> getAllTrailerByMovie(long movieId) {

        List<Movie> movieEntityResponse = movieRepository.findAll();

        Predicate<? super Movie> predicate = (movie -> movie.getId() == movieId);
        Movie movieById = movieEntityResponse.stream().filter(predicate).findFirst().orElseThrow(() ->
                new ApplicationException(
                        "Movie-Or-Series-Not-Found",
                        String.format("Can't find movie or series with id=%d", movieId),
                        HttpStatus.NOT_FOUND
                ));

        List<Trailer> trailers = movieById.getTrailers();

        return trailers.stream().map(this::mapToDTO).collect(Collectors.toList());

    }

    @Override
    public String deleteTrailerByMovie(long movieId, long trailerId) {

        Movie movie = movieRepository.findById(movieId).orElseThrow(() ->
                new ApplicationException(
                        "Movie-Or-Series-Not-Found",
                        String.format("Can't find movie or series with id=%d", movieId),
                        HttpStatus.NOT_FOUND
                ));

        Predicate<? super Trailer> Predicate = (trailer -> trailer.getId() == trailerId);
        Trailer trailerCanBeFound = movie.getTrailers().stream().filter(Predicate).findFirst().orElseThrow(
                () ->
                        new ApplicationException(
                                "Trailer can be found",
                                String.format("Can't find trailer with id=%d", trailerId),
                                HttpStatus.BAD_REQUEST
                        )
        );

        trailerRepository.deleteById(trailerId);

        return "Trailer has been deleted!";
    }

    private TrailerDTO mapToDTO(Trailer trailer){

        return mapper.map(trailer, TrailerDTO.class);

    }

    private Trailer mapToEntity(TrailerDTO trailerDTO){

        return  mapper.map(trailerDTO, Trailer.class);

    }

}
