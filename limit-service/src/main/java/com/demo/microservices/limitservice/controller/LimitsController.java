package com.demo.microservices.limitservice.controller;

import com.demo.microservices.limitservice.config.Config;
import com.demo.microservices.limitservice.entity.Limits;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitsController {

    @Autowired
    private Config config;


    @GetMapping("/limits")
    public Limits getLimits(){

        return new Limits(config.getMinimum(), config.getMaximum());

    }
}
