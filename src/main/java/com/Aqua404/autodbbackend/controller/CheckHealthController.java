package com.aqua404.autodbbackend.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("v1")
@RequiredArgsConstructor
@Slf4j
public class CheckHealthController implements CheckHealthApi{
    @Override
    public ResponseEntity<HttpStatus> checkHealth() {
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
