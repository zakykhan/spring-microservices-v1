package com.demo.microservice.currencyexchangeservice.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.microservice.currencyexchangeservice.entity.CurrencyExchange;

public interface CurrencyExchangeDao extends JpaRepository<CurrencyExchange, Long>{
	
	public CurrencyExchange findByFromAndTo(String from, String to);

}
