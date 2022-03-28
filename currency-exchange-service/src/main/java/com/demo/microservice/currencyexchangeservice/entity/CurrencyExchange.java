package com.demo.microservice.currencyexchangeservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "currency_exchange")
public class CurrencyExchange {

	@Id
    private Long id;

	@Column(name = "currency_from")
	private String from;

	@Column(name = "currency_to")
    private String to;

    private BigDecimal conversionMultiple;
    
    private String environment;
    

}
