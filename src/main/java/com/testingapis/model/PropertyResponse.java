package com.testingapis.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown=true)
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Getter
public class PropertyResponse {
    @JsonProperty("title")
    private String title;
    @JsonProperty("err")
    private String err;
    @JsonProperty("count")
    private int count;
    @JsonProperty("data")
    private List<PropertyData> data;
    // Constructor, getters, setters, etc.
}