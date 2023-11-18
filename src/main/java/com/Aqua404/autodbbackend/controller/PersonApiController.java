package com.aqua404.autodbbackend.controller;

import com.aqua404.autodbbackend.model.PersonResponse;
import com.aqua404.autodbbackend.service.PersonService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1")
@RequiredArgsConstructor
@Slf4j
public class PersonApiController implements PersonApi {

    private final PersonService service;

    @Override
    public ResponseEntity<PersonResponse> getPerson(String id) {
        return ResponseEntity.ok(PersonResponse.builder().person(service.getPerson(id)).build());


    }
}
