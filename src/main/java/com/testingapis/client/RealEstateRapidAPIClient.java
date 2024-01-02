package com.testingapis.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.testingapis.config.RestClient;
import com.testingapis.model.PropertyData;
import com.testingapis.model.PropertyResponse;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

//@Bean
public class RealEstateRapidAPIClient extends RestClient {

    public List<PropertyData> getRealEstateData() throws  java.io.IOException, java.lang.InterruptedException{
        HttpRequest request1 = HttpRequest.newBuilder()
                .uri(URI.create("https://real-estate-records.p.rapidapi.com/search/zipcode?zipcode=10019&page=1"))
                .header("X-RapidAPI-Key", "28a3d41b57msh6aa13b814f50c0ep181acfjsne6aef7f124a3")
                .header("X-RapidAPI-Host", "real-estate-records.p.rapidapi.com")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response1 = HttpClient.newHttpClient().send(request1, HttpResponse.BodyHandlers.ofString());
        System.out.println(response1.body());
        System.out.println ("Parsing using Jackson API");
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
        // objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        PropertyResponse propertyResponse = objectMapper.readValue(response1.body(), PropertyResponse.class);

        // Access the parsed data
        System.out.println("Title: " + propertyResponse.getTitle());
        System.out.println("Error: " + propertyResponse.getErr());
        System.out.println("Count: " + propertyResponse.getCount());

        List<PropertyData> propertyDataList1 = propertyResponse.getData();
        if (propertyDataList1 != null && !propertyDataList1.isEmpty()) {
            PropertyData propertyData = propertyDataList1.get(0);
            System.out.println("Street Number: " + propertyData.getId().getStreetNumber());
            System.out.println("Street: " + propertyData.getId().getStreet());
            System.out.println("Property Type: " + propertyData.getId().getStreet());
            System.out.println("Zipcode: " + propertyData.getId().getZipcode());
            System.out.println("State: " + propertyData.getId().getState());
            System.out.println("Last Sales Date: " + propertyData.getLastSalesDate());
            System.out.println("Last Sales Amount: " + propertyData.getLastSalesAmount());
            System.out.println("Max Sales Amount: " + propertyData.getMaxSalesAmount());
            System.out.println("Total Records: " + propertyData.getTotalRecords());
        }
        return propertyResponse.getData();
    }

}
