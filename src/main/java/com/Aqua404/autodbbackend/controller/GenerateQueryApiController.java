package com.aqua404.autodbbackend.controller;

import com.aqua404.autodbbackend.model.QueryData;
import com.aqua404.autodbbackend.service.GenerateQueryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("v1")
@RequiredArgsConstructor
@Slf4j
public class GenerateQueryApiController implements GenerateQueryApi {

    private final GenerateQueryService service;

    @Override
    public List<String> getQuery(QueryData queryData) {
        return service.generateQuery(queryData);
    }
}
