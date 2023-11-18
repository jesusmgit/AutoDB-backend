package com.aqua404.autodbbackend.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Field {

    @JsonProperty("name_field")
    private String name;
    @JsonProperty("type")
    private String type;
    @JsonProperty("size")
    private Integer size;
    @JsonProperty("pk")
    private boolean pk;
    @JsonProperty("not_null")
    private boolean notNull;
    @JsonProperty("fk")
    private ForeignKey fk;
    @JsonProperty("unique")
    private boolean unique;
    @JsonProperty("autoincrement")
    private boolean autoincrement;
    @JsonProperty("default")
    private String defaultField;
    @JsonProperty("first_field")
    private boolean firstField;
    @JsonProperty("last_field")
    private boolean lastfield;
}
