package com.aqua404.autodbbackend.model;

import ch.qos.logback.core.status.Status;
import com.aqua404.autodbbackend.entity.Person;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import javax.xml.transform.Result;
import java.util.Optional;

@Builder
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PersonResponse {
    private Status status;
    private Result result;
    private Optional<Person> person;
}
