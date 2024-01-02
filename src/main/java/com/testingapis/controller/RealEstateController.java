package com.testingapis.controller;

import com.testingapis.model.PropertyData;
import com.testingapis.service.RealEstateService;
import org.springframework.beans.factory.annotation.Autowired;
import  org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;

@Controller
public class RealEstateController {

    @Autowired
    private RealEstateService restApiService;
    @PostMapping("/realestate/data")
    public void populateRealEstateRecords() throws IOException, InterruptedException{
        restApiService.populateRealEstateRecordsFromRapid();
    }

    public List<PropertyData> getRealEstateReords() {
        return restApiService.get
    }
}
