package com.amarnath.movie.service;

import com.amarnath.movie.dto.AiredDTO;

public interface AiredService {

    AiredDTO getAiredDate(long movieId);
    AiredDTO postAiredDate(long movieId, AiredDTO airedDTOData);

}
