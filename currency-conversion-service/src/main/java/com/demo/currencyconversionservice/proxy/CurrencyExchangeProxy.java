package com.demo.currencyconversionservice.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.demo.currencyconversionservice.entity.CurrencyConversion;


@FeignClient(name = "currency-exchange")
public interface CurrencyExchangeProxy {
	
    @GetMapping("/currency-exchange/{from}/{to}")
    public CurrencyConversion getExchangedValue(@PathVariable("from") String from, @PathVariable("to") String to);


}
