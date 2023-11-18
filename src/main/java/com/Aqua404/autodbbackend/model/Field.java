package com.aqua404.autodbbackend.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Field {

    @JsonProperty("")
    private String name;
    @JsonProperty("")
    private String type;
    @JsonProperty("")
    private boolean pk;
    @JsonProperty
    private boolean notNull;
    @JsonProperty("fk")
    private ForeignKey fk;

}
