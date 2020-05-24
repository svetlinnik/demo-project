package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exchange.CurrencyExchanger;
import com.example.demo.model.CalculationResult;
import com.example.demo.model.Country;
import com.example.demo.model.CountryExchangeResult;
import com.example.demo.model.StartingCountry;
import com.example.demo.providers.NeighbourCountriesProvider;

@Service
public class NeighbourCountriesCalculateTripService {

	private final CurrencyExchanger currencyConverter;
	private final NeighbourCountriesProvider neighbourCountriesProvider;

	@Autowired
	public NeighbourCountriesCalculateTripService(NeighbourCountriesProvider neighbourCountriesProvider,
			CurrencyExchanger currencyExchanger) {
		this.neighbourCountriesProvider = neighbourCountriesProvider;
		this.currencyConverter = currencyExchanger;
	}

	public CalculationResult calculateNeighbourTrips(StartingCountry startingCountry, int totalBudget,
			int countryBudget, String inputCurrency) {
		List<Country> neighbourCountries = neighbourCountriesProvider.getNeighbourCountries(startingCountry);
		int neededMoneyForOneTrip = countryBudget * neighbourCountries.size();
		int neighbourCountriesTravelCount = totalBudget / neededMoneyForOneTrip;
		int leftOver = totalBudget % neededMoneyForOneTrip;
		List<CountryExchangeResult> countryCurrencyConversionResults = exchangeCountryBudgetToCountryCurrencies(
				countryBudget, inputCurrency, neighbourCountries);
		return new CalculationResult(neighbourCountriesTravelCount, leftOver, inputCurrency,
				countryCurrencyConversionResults);
	}

	private List<CountryExchangeResult> exchangeCountryBudgetToCountryCurrencies(int countryBudget,
			String inputCurrency, List<Country> neighbourCountries) {
		List<CountryExchangeResult> countryCurrencyConversionResults = new ArrayList<>();
		for (Country country : neighbourCountries) {
			CountryExchangeResult convertionResult = currencyConverter.exchange(country, countryBudget, inputCurrency);
			countryCurrencyConversionResults.add(convertionResult);
		}
		return countryCurrencyConversionResults;
	}

}
