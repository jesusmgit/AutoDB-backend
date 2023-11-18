package com.aqua404.autodbbackend.controller;

import com.aqua404.autodbbackend.model.PersonResponse;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Validated
public interface PersonApi {

    @GetMapping(value = "/person/{id}")
    ResponseEntity<PersonResponse> getPerson(
            @Valid @NotNull @PathVariable("id") final String id);
}
