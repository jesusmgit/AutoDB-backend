package com.aqua404.autodbbackend.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Table {

    @JsonProperty("table_name")
    private String tableName;

    @JsonProperty("datos")
    private List<Field> fields;

}
