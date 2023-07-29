package com.amarnath.movie.dto;

import lombok.Data;

import java.util.Date;

@Data
public class AiredDTO {

    private long id;

    private Date airDate;

    private Date endDate;

}
