package com.testingapis.config;

import com.testingapis.client.RealEstateRapidAPIClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RestClient {
    @Bean
    public RealEstateRapidAPIClient rapidAPIClient () {
      return new RealEstateRapidAPIClient();
    }
}
