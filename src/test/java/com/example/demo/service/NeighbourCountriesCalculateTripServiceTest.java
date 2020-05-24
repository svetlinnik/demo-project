package com.example.demo.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.example.demo.exchange.CurrencyExchanger;
import com.example.demo.model.CalculationResult;
import com.example.demo.model.Country;
import com.example.demo.model.StartingCountry;
import com.example.demo.providers.NeighbourCountriesProvider;

@RunWith(MockitoJUnitRunner.class)
public class NeighbourCountriesCalculateTripServiceTest {

	@Mock
	private CurrencyExchanger currencyExchanger;

	@Mock
	private NeighbourCountriesProvider neighbourCountriesProvider;

	@InjectMocks
	private NeighbourCountriesCalculateTripService neighbourCountriesCalculateTripService;

	@Test
	public void calculateNeighbourTrips_whenThereAreCountriesWithCorrectData_ThereIsCorrectResult() {
		Country tr = new Country("TR", "TRY");
		Country gr = new Country("GR", "EUR");
		Country ro = new Country("RO", "RON");
		Country sr = new Country("SR", "RSD");
		Country mk = new Country("MK", "MKD");
		List<Country> neighbourCountries = Arrays.asList(tr, gr, ro, sr, mk);
		when(neighbourCountriesProvider.getNeighbourCountries(StartingCountry.BG)).thenReturn(neighbourCountries);
		CalculationResult result = neighbourCountriesCalculateTripService.calculateNeighbourTrips(StartingCountry.BG, 1200, 100, "EUR");
		assertEquals(2, result.getNeighbourCountriesTravelCount());
		assertEquals(200, result.getLeftOver());
		assertEquals("EUR", result.getLeftOverCurrency());
		assertEquals(5, result.getNeighbourCountriesResult().size());
	}
}
