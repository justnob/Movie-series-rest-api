package com.amarnath.movie.repository;

import com.amarnath.movie.dto.MovieDTO;
import com.amarnath.movie.dto.TrailerDTO;
import com.amarnath.movie.entity.Trailer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TrailerRepository extends JpaRepository<Trailer, Long> {

    List<TrailerDTO> findByMovie(MovieDTO movieDTO);

}
