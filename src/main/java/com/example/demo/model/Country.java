package com.example.demo.model;

public class Country {
	
	private final String currency;
	private final String isoCode;
	
	public Country(String isoCode, String currency) {
		this.currency = currency;
		this.isoCode = isoCode;
	}

	public String getCurrency() {
		return currency;
	}

	public String getIsoCode() {
		return isoCode;
	}
}
