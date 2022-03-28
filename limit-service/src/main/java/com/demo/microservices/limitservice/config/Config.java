package com.demo.microservices.limitservice.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties("limit-service")
@Component
@Data
public class Config {

    private int minimum;

    private int maximum;
}
