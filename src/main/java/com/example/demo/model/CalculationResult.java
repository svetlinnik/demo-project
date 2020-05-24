package com.example.demo.model;

import java.util.List;

public class CalculationResult {
	
	private final int neighbourCountriesTravelCount;
	private final int leftOver;
	private final String leftOverCurrency;
	private final List<CountryExchangeResult> neighbourCountriesResult;
	
	public CalculationResult(int neighbourCountriesTravelCount, int leftOver, String leftOverCurrency, List<CountryExchangeResult> neighbourCountriesResult) {
		this.leftOver = leftOver;
		this.leftOverCurrency = leftOverCurrency;
		this.neighbourCountriesResult = neighbourCountriesResult;
		this.neighbourCountriesTravelCount = neighbourCountriesTravelCount;
	}

	public int getLeftOver() {
		return leftOver;
	}

	public String getLeftOverCurrency() {
		return leftOverCurrency;
	}

	public List<CountryExchangeResult> getNeighbourCountriesResult() {
		return neighbourCountriesResult;
	}

	public int getNeighbourCountriesTravelCount() {
		return neighbourCountriesTravelCount;
	}
}
