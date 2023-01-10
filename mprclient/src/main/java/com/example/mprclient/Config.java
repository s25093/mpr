package com.example.mprclient;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class Config {
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }
}
