package com.amarnath.movie.errorhandeling;

import ch.qos.logback.core.spi.ErrorCodes;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ApplicationException.class)
    public ResponseEntity<?> handleNotFoundException(
            ApplicationException exception, HttpServletRequest request
    ){

        var response = new ApiErrorResponse(
                exception.getErrorCode(),
                exception.getMessage(),
                exception.getHttpStatus().value(),
                exception.getHttpStatus().name(),
                request.getRequestURI(),
                request.getMethod(),
                LocalDateTime.now()
        );

        return new ResponseEntity<>(response, exception.getHttpStatus());

    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleUnknownException(
            Exception exception, HttpServletRequest request
    ){

        var response = new ApiErrorResponse(
                ErrorCodes.EMPTY_MODEL_STACK,
                "Internal Server Error",
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                HttpStatus.INTERNAL_SERVER_ERROR.name(),
                request.getRequestURI(),
                request.getMethod(),
                LocalDateTime.now()
        );

        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);

    }

}
