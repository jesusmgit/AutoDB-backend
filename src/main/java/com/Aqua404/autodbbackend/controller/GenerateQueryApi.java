package com.aqua404.autodbbackend.controller;

import com.aqua404.autodbbackend.model.QueryData;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Validated
@CrossOrigin(origins = {"*"})
public interface GenerateQueryApi {

    @PostMapping(value = "/generate-sql")
    List<String> getQuery(
            @Valid @NotNull @RequestBody  final QueryData queryData);
}
