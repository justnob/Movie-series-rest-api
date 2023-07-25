package com.amarnath.movie.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
public class RateDTO {

    private long id;
    private float rating;

}
