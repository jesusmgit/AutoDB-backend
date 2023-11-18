package com.aqua404.autodbbackend.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class ExceptionManager {

    @ExceptionHandler(TrimException.class)
    public ResponseEntity<ErrorResponse> proccessDatabaseException(final TrimException e){
        log.info(e.getMessage(), e);
        return handleHttpException(e.getStatusCode(),e.getMessage(),e);
    }

    private ResponseEntity<ErrorResponse> handleHttpException(HttpStatus ht,  String description, TrimException e){
        return ResponseEntity.status(ht).body(ErrorResponse.builder(e,ht,description).build());
    }
}
