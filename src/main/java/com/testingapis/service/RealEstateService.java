package com.testingapis.service;

import com.testingapis.client.RealEstateRapidAPIClient;
import com.testingapis.model.PropertyData;
import com.testingapis.repository.DbRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

@Service
public class RealEstateService {

    @Autowired
    private RealEstateRapidAPIClient rapidAPIClient;
    @Autowired
    private DbRepository dbRepository;

    public void populateRealEstateRecordsFromRapid() throws IOException, InterruptedException {
        List<PropertyData> propertyData = rapidAPIClient.getRealEstateData();
        dbRepository.insertRealEstateData(propertyData);
    }

    public List<PropertyData> getRealEstateRecords() {
        List<PropertyData> propertyList = new ArrayList<PropertyData>();
        return propertyList;
    }

}
