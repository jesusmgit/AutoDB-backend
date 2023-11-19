package com.aqua404.autodbbackend.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
@CrossOrigin(origins = {"*"})

public interface CheckHealthApi {

    @GetMapping(value = "/checkHealth")
    ResponseEntity<HttpStatus> checkHealth();
}
