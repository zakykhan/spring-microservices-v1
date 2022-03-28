package com.demo.microservice.currencyexchangeservice.controller;

import com.demo.microservice.currencyexchangeservice.Dao.CurrencyExchangeDao;
import com.demo.microservice.currencyexchangeservice.entity.CurrencyExchange;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CurrencyExchangeController {

    @Autowired
    private Environment environment;
    
    @Autowired
    private CurrencyExchangeDao currencyExchangeDao;
    
    Logger logger = LoggerFactory.getLogger(CurrencyExchangeController.class);

    @GetMapping("/currency-exchange/{from}/{to}")
    public CurrencyExchange getExchangedValue(@PathVariable("from") String from, @PathVariable("to") String to){
        String port = environment.getProperty("local.server.port");
        
        CurrencyExchange currencyExchange = currencyExchangeDao.findByFromAndTo(from, to);
        currencyExchange.setEnvironment(port);
        
        logger.info("Inside getExchanged method of currency exchange controller");

        //CurrencyExchange currencyExchange = new CurrencyExchange(100L, from, to, BigDecimal.ONE, port);
        return currencyExchange;

    }
}
