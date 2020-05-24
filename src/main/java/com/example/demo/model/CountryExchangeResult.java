package com.example.demo.model;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonFormat;

public class CountryExchangeResult {
	
	private final String countryIsoCode;
	private final String currency;
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	private final BigDecimal amount;

	public CountryExchangeResult(String countryIsoCode, String currency, BigDecimal amount) {
		this.countryIsoCode = countryIsoCode;
		this.currency = currency;
		this.amount = amount;
	}

	public String getCountryIsoCode() {
		return countryIsoCode;
	}

	public String getCurrency() {
		return currency;
	}

	public BigDecimal getAmount() {
		return amount;
	}

}
