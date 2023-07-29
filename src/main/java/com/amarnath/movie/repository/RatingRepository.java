package com.amarnath.movie.repository;

import com.amarnath.movie.dto.MovieDTO;
import com.amarnath.movie.dto.RateDTO;
import com.amarnath.movie.entity.Rate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RatingRepository extends JpaRepository<Rate, Long> {

    List<RateDTO> findByMovie(MovieDTO movieDTO);

}
