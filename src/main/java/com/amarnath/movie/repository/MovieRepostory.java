package com.amarnath.movie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amarnath.movie.entity.Movie;

public interface MovieRepostory extends JpaRepository<Movie, Long>{

}
