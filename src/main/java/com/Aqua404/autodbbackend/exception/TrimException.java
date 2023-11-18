package com.aqua404.autodbbackend.exception;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@RequiredArgsConstructor
public class TrimException extends RuntimeException {
    private HttpStatus statusCode;
    private String table;


    public TrimException(HttpStatus httpStatus, String personTable) {
        this.statusCode = httpStatus;
        this.table = personTable;
    }
}
