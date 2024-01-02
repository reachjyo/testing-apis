package com.testingapis.model;
import java.util.Date;
public record RealEstateData (
        int propertyId,
        String streetNumber,
        String street,
        String propertyType,
        int zipCode,
        String state,
        Date lastSalesDate,
        int lastSalesAmount,
        int maxSalesAmount,
        int totalRecords,
        Date lastModifiedDate)
{

}

