package com.testingapis.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown=true)
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Getter
public class PropertyData {

    @JsonProperty("_id")
    private PropertyId id;
    @JsonProperty("lastSalesDate")
    private Date lastSalesDate;
    @JsonProperty("lastSalesAmount")
    private int lastSalesAmount;
    @JsonProperty("maxSalesAmount")
    private int maxSalesAmount;
    @JsonProperty("TotalRecords")
    private int totalRecords;

    // Constructor, getters, setters, etc.

}