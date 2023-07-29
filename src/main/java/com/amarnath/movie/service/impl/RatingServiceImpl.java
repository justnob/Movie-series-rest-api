package com.amarnath.movie.service.impl;

import com.amarnath.movie.dto.RateDTO;
import com.amarnath.movie.entity.Movie;
import com.amarnath.movie.entity.Rate;
import com.amarnath.movie.errorhandeling.ApplicationException;
import com.amarnath.movie.repository.MovieRepository;
import com.amarnath.movie.repository.RatingRepository;
import com.amarnath.movie.service.RatingService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Predicate;

@Service
public class RatingServiceImpl implements RatingService {

    private final ModelMapper modelMapper;
    private final MovieRepository movieRepository;
    private final RatingRepository ratingRepository;

    @Autowired
    public RatingServiceImpl(ModelMapper modelMapper, MovieRepository movieRepository, RatingRepository ratingRepository) {
        this.modelMapper = modelMapper;
        this.movieRepository = movieRepository;
        this.ratingRepository = ratingRepository;
    }

    @Override
    public RateDTO updateRatingByMovieById(long movieId, long ratingId, RateDTO rating) {

        List<Movie> movieEntityResponse = movieRepository.findAll();

        Predicate<? super Movie> predicate = (movie -> movie.getId() == movieId);
        Movie movieById = movieEntityResponse.stream().filter(predicate).findFirst().orElseThrow(() ->
                new ApplicationException(
                        "Movie-Or-Series-Not-Found",
                        String.format("Can't find movie or series with id=%d", movieId),
                        HttpStatus.NOT_FOUND
                ));

        Rate allRatings = ratingRepository.findById(ratingId).orElseThrow(() ->
                new ApplicationException(
                        "The Rating can't be found",
                        String.format("Can't find the value to the rating id=%d", ratingId),
                        HttpStatus.NOT_FOUND
                )
        );

        if(movieById.getRating().getId() != ratingId){

            throw new ApplicationException(
                    "The rating id is not assigned to this movie",
                    String.format("Can't assign the value to the rating id=%d", ratingId),
                    HttpStatus.BAD_REQUEST
            );

        }


        Rate rate = mapToEntity(rating);

        allRatings.setRating(rate.getRating());

        Rate save = ratingRepository.save(allRatings);

        return mapToDTO(save);
    }

    @Override
    public RateDTO getRatingByMovieById(long movieId, long ratingId) {

        List<Movie> movieEntityResponse = movieRepository.findAll();

        Predicate<? super Movie> predicate = (movie -> movie.getId() == movieId);
        Movie movieById = movieEntityResponse.stream().filter(predicate).findFirst().orElseThrow(() ->
                new ApplicationException(
                        "Movie-Or-Series-Not-Found",
                        String.format("Can't find movie or series with id=%d", movieId),
                        HttpStatus.NOT_FOUND
                ));

        if(movieById.getRating().getId() != ratingId){

            throw new ApplicationException(
                    "The rating id is not assigned to this movie",
                    String.format("The rating id=%d does not exist for this movie", ratingId),
                    HttpStatus.NOT_FOUND
            );

        }



        return mapToDTO(ratingRepository.findById(ratingId).orElseThrow(() ->
                new ApplicationException(
                        "The Rating can't be found",
                        String.format("Can't find the value to the rating id=%d", ratingId),
                        HttpStatus.NOT_FOUND
                )));
    }

    @Override
    public RateDTO createRatingByMovieById(long movieId, RateDTO rating) {

        List<Movie> movieEntityResponse = movieRepository.findAll();

        Predicate<? super Movie> predicate = (movie -> movie.getId() == movieId);
        Movie movieById = movieEntityResponse.stream().filter(predicate).findFirst().orElseThrow(() ->
                new ApplicationException(
                        "Movie-Or-Series-Not-Found",
                        String.format("Can't find movie or series with id=%d", movieId),
                        HttpStatus.NOT_FOUND
                ));

        if(movieById.getRating() != null){

            throw new ApplicationException(
                    "Rating already exist",
                    String.format("Movie or series with id=%d rating already exist", movieId),
                    HttpStatus.BAD_REQUEST
            );

        }

        Rate rate = mapToEntity(rating);


        Rate saveRateInMovie = ratingRepository.save(rate);

        movieRepository.findById(movieId).orElseThrow(() ->

                new ApplicationException(
                        "Movie-Or-Series-Not-Found",
                        String.format("Can't find movie or series with id=%d", movieId),
                        HttpStatus.NOT_FOUND
                ));

        movieById.setRating(mapToEntity(rating));

        movieRepository.save(movieById);

        return mapToDTO(saveRateInMovie);

    }


    private RateDTO mapToDTO(Rate rate) {

        return modelMapper.map(rate, RateDTO.class);

    }

    private Rate mapToEntity(RateDTO rateDTO) {

        return modelMapper.map(rateDTO, Rate.class);

    }

}
