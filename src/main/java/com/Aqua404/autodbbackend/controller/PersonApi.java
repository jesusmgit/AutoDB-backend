package com.aqua404.autodbbackend.controller;

import com.aqua404.autodbbackend.entity.Person;
import com.aqua404.autodbbackend.model.PersonResponse;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import oracle.ucp.proxy.annotation.Post;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@CrossOrigin(origins = {"*"})
public interface PersonApi {

    @GetMapping(value = "/person/{id}")
    ResponseEntity<Person> getPerson(
            @Valid @NotNull @PathVariable("id") final String id);

    @PostMapping(value = "/person")
    ResponseEntity<Person> getQuery(
            @Valid @NotNull @RequestBody  final Person person);
}
