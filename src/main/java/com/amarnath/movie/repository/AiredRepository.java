package com.amarnath.movie.repository;

import com.amarnath.movie.dto.AiredDTO;
import com.amarnath.movie.dto.MovieDTO;
import com.amarnath.movie.entity.Aired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AiredRepository extends JpaRepository<Aired, Long> {

    List<AiredDTO> findByMovie(MovieDTO movieDTO);

}
