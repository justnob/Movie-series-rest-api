package com.amarnath.movie.controller;

import com.amarnath.movie.dto.AiredDTO;
import com.amarnath.movie.service.AiredService;
import com.amarnath.movie.service.impl.AiredServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AiredController {

    private final AiredService airedService;

    @Autowired
    public AiredController(AiredService airedService) {
        this.airedService = airedService;
    }

    @GetMapping("/api/v1/movies/{movieId}/aired")
    private ResponseEntity<AiredDTO> getAiredDateForMovie(
            @PathVariable long movieId){

        return new ResponseEntity<>(airedService.getAiredDate(movieId), HttpStatus.OK);

    }

    @PostMapping("/api/v1/movies/{movieId}/aired")
    private ResponseEntity<AiredDTO> addAiredDateToAMovie(@PathVariable long movieId,
        @RequestBody AiredDTO airedDTO
    ){

        return new ResponseEntity<>(airedService.postAiredDate(movieId,airedDTO), HttpStatus.CREATED);

    }

}
