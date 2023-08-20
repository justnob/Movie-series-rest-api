package com.amarnath.movie.service.impl;

import com.amarnath.movie.dto.AiredDTO;
import com.amarnath.movie.entity.Aired;
import com.amarnath.movie.entity.Movie;
import com.amarnath.movie.errorhandeling.ApplicationException;
import com.amarnath.movie.repository.AiredRepository;
import com.amarnath.movie.repository.MovieRepository;
import com.amarnath.movie.service.AiredService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class AiredServiceImpl implements AiredService {

    private final AiredRepository airedRepository;
    private final ModelMapper mapper;
    private final MovieRepository movieRepository;

    @Autowired
    public AiredServiceImpl(AiredRepository airedRepository, ModelMapper mapper, MovieRepository movieRepository) {
        this.airedRepository = airedRepository;
        this.mapper = mapper;
        this.movieRepository = movieRepository;
    }

    @Override
    public AiredDTO getAiredDate(long movieId) {

        Movie movieSearch = movieRepository.findById(movieId).orElseThrow(() ->
                new ApplicationException(
                        "Movie-Or-Series-Not-Found",
                        String.format("Can't find movie or series with id=%d", movieId),
                        HttpStatus.NOT_FOUND
                )
        );

        return mapTODto(airedRepository.findById(movieSearch.getAired().getId()).orElseThrow(() ->
                new ApplicationException(
                        "The Aired Date can't be found",
                        String.format("Can't find the value to the rating id=%d", (movieSearch.getAired().getId())),
                        HttpStatus.NOT_FOUND
                )
                ));

    }

    @Override
    public AiredDTO postAiredDate(long movieId, AiredDTO airedDTOData) {

        Movie movieSearch = movieRepository.findById(movieId).orElseThrow(() ->
                new ApplicationException(
                        "Movie-Or-Series-Not-Found",
                        String.format("Can't find movie or series with id=%d", movieId),
                        HttpStatus.NOT_FOUND
                )
        );

        if (movieSearch.getAired() != null){

            throw new ApplicationException(
                    "Aired Date Already Exist",
                    "can't add it",
                    HttpStatus.BAD_REQUEST
                    );

        }

        Aired airedEntity = mapToEntity(airedDTOData);

        movieSearch.setAired(airedEntity);
        movieRepository.save(movieSearch);

        Aired savedData = airedRepository.save(airedEntity);

        return mapTODto(savedData);

    }


    private AiredDTO mapTODto(Aired aired){

        return mapper.map(aired, AiredDTO.class);

    }

    private Aired mapToEntity(AiredDTO airedDTO){

        return mapper.map(airedDTO, Aired.class);

    }

}
