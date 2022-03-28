package com.demo.currencyconversionservice.controller;

import java.math.BigDecimal;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.demo.currencyconversionservice.entity.CurrencyConversion;
import com.demo.currencyconversionservice.proxy.CurrencyExchangeProxy;

@RestController
public class CurrencyConversionController {

	@Autowired
	private Environment environment;
	
	@Autowired
	private CurrencyExchangeProxy currencyExchangeProxy;

	@GetMapping("/currency-conversion/{from}/{to}/{quantity}")
	public CurrencyConversion getConvertedAmount(@PathVariable("from") String from, @PathVariable("to") String to,
			@PathVariable("quantity") BigDecimal quantity) {
		String port = environment.getProperty("local.server.port");

		HashMap<String, String> uriVariables = new HashMap<>();
		uriVariables.put("from", from);
		uriVariables.put("to", to);
		
		CurrencyConversion response = currencyExchangeProxy.getExchangedValue(from, to);

		 return new CurrencyConversion(1001L,from, to, quantity, quantity.multiply(response.getConversionMultiple()), BigDecimal.ONE ,port);
	}
	
	@GetMapping("/currency-conversion-feign/{from}/{to}/{quantity}")
	public CurrencyConversion getConvertedAmountUsingFeign(@PathVariable("from") String from, @PathVariable("to") String to,
			@PathVariable("quantity") BigDecimal quantity) {
		String port = environment.getProperty("local.server.port");

		HashMap<String, String> uriVariables = new HashMap<>();
		uriVariables.put("from", from);
		uriVariables.put("to", to);
		
		CurrencyConversion response = currencyExchangeProxy.getExchangedValue(from, to);

		 return new CurrencyConversion(1001L,from, to, quantity, quantity.multiply(response.getConversionMultiple()), BigDecimal.ONE ,port);
	}

}
