package com.example.demo.exchange;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.model.Country;
import com.example.demo.model.CountryExchangeResult;
import com.example.demo.providers.CurrencyExchangeRateProvider;

@Component
public class CurrencyExchanger {

	private final CurrencyExchangeRateProvider currencyProvider;

	@Autowired
	public CurrencyExchanger(CurrencyExchangeRateProvider currencyProvider) {
		this.currencyProvider = currencyProvider;
	}

	public CountryExchangeResult exchange(Country countryToExchangeTo, int countryBudget, String fromCurrency) {
		BigDecimal countryBudgetBigDecimal = new BigDecimal(countryBudget).setScale(2);
		BigDecimal exchangeRate = currencyProvider.getCurrencyExcangeRate(fromCurrency,
				countryToExchangeTo.getCurrency());
		if (fromCurrency.equals(countryToExchangeTo.getCurrency()) || exchangeRate.equals(BigDecimal.ZERO)) {
			return new CountryExchangeResult(countryToExchangeTo.getIsoCode(), fromCurrency, countryBudgetBigDecimal);
		}
		BigDecimal conversionResult = countryBudgetBigDecimal.multiply(exchangeRate).setScale(2, RoundingMode.CEILING);
		return new CountryExchangeResult(countryToExchangeTo.getIsoCode(), countryToExchangeTo.getCurrency(),
				conversionResult);
	}

}