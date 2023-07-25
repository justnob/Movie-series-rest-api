package com.amarnath.movie.repository;

import com.amarnath.movie.entity.Rate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RatingRepository extends JpaRepository<Rate, Long> {



}
