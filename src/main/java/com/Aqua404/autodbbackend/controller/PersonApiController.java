package com.aqua404.autodbbackend.controller;

import com.aqua404.autodbbackend.entity.Person;
import com.aqua404.autodbbackend.model.PersonResponse;
import com.aqua404.autodbbackend.service.PersonService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("v1")
@RequiredArgsConstructor
@Slf4j
public class PersonApiController implements PersonApi {

    private final PersonService service;

    @Override
    public ResponseEntity<Person> getPerson(String id) {
        Optional<Person> optPerson = service.getPerson(id);
        if (optPerson.isEmpty()){
            return new ResponseEntity<Person>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(service.getPerson(id).get());
    }

    @Override
    public ResponseEntity<Person> getQuery(Person person) {
        var id = "";
        Optional<Person> optPerson = service.getPerson(id);
        return null;
    }
}
