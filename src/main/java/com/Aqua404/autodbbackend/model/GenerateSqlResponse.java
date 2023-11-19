package com.aqua404.autodbbackend.model;

import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;

import java.util.List;

@Data
@Slf4j
@Builder
public class GenerateSqlResponse {

    private List<String> querys;
    private HttpStatus status;
}
