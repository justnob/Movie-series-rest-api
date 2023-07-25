package com.amarnath.movie.errorhandeling;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ApiErrorResponse {

    private String errorCode;
    private String message;
    private int statusCode;
    private String statusName;
    private String path;
    private String method;
    private LocalDateTime timeStamp;

}
