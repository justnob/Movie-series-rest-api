package com.amarnath.movie.repository;

import com.amarnath.movie.dto.GenreDTO;
import com.amarnath.movie.dto.MovieDTO;
import com.amarnath.movie.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GenreRepository extends JpaRepository<Genre, Long> {

    List<GenreDTO> findByMovie(MovieDTO movieDTO);

}
