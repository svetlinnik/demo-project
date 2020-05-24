package com.example.demo.providers;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class CurrencyExchangeRateProvider {

	//mock data instead of using external rest api for simplicity
	private final Map<String, Map<String, BigDecimal>> currenciesExchangeRate;
	
	{
		Map<String, BigDecimal> bgnToOthers = new HashMap<>();
		bgnToOthers.put("TRY", new BigDecimal("3.79948"));
		bgnToOthers.put("RON", new BigDecimal("2.47593"));
		bgnToOthers.put("RSD", new BigDecimal("60.14160"));
		bgnToOthers.put("MKD", new BigDecimal("31.49650"));
		bgnToOthers.put("EUR", new BigDecimal("0.511291"));
		Map<String, BigDecimal> eurToOthers = new HashMap<>();
		eurToOthers.put("TRY", new BigDecimal("7.43116"));
		eurToOthers.put("RON", new BigDecimal("4.84265"));
		eurToOthers.put("RSD", new BigDecimal("117.62700"));
		eurToOthers.put("MKD", new BigDecimal("61.60200"));
		currenciesExchangeRate = new HashMap<>();
		currenciesExchangeRate.put("EUR", eurToOthers);
		currenciesExchangeRate.put("BGN", bgnToOthers);
	}
	
	public BigDecimal getCurrencyExcangeRate(String fromCurrency, String toCurrency) {
		if(currenciesExchangeRate.containsKey(fromCurrency) && currenciesExchangeRate.get(fromCurrency).containsKey(toCurrency)) {
			return currenciesExchangeRate.get(fromCurrency).get(toCurrency);
		}
		return BigDecimal.ZERO;
	}
}
