package com.testingapis.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@JsonIgnoreProperties(ignoreUnknown=true)
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Getter
public class PropertyId {
    @JsonProperty("STREET_NUMBER")
    private String streetNumber;
    @JsonProperty("STREET")
    private String street;
    @JsonProperty("PROPERTY_TYPE")
    private String propertyType;
    @JsonProperty("ZIPCODE")
    private String zipcode;
    @JsonProperty("STATE")
    private String state;

    // Constructor, getters, setters, etc.
}