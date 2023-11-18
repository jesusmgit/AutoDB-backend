package com.aqua404.autodbbackend.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ForeignKey {

    @JsonProperty("table_name")
    private String tableName;

    @JsonProperty("pk")
    private String pk;
}
