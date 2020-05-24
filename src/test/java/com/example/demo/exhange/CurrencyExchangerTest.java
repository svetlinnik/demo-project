package com.example.demo.exhange;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.example.demo.exchange.CurrencyExchanger;
import com.example.demo.model.Country;
import com.example.demo.model.CountryExchangeResult;
import com.example.demo.providers.CurrencyExchangeRateProvider;

@RunWith(MockitoJUnitRunner.class)
public class CurrencyExchangerTest {
	
	@Mock
	private CurrencyExchangeRateProvider currencyProvider;
	
	@InjectMocks
	private CurrencyExchanger currencyExchanger;

	@Test
	public void exchange_whenThereIsNoEchangeRate_TheFromCurrencyIsReturned() {
		when(currencyProvider.getCurrencyExcangeRate("EUR", "CHF"))
		.thenReturn(BigDecimal.ZERO);
		Country country = new Country("CH", "CHF");
		CountryExchangeResult result = currencyExchanger.exchange(country, 100, "EUR");
		assertEquals(country.getIsoCode(), result.getCountryIsoCode());
		assertNotEquals(country.getCurrency(), result.getCurrency());
		assertEquals("EUR", result.getCurrency());
	}

	@Test
	public void exchange_whenFromCurrencyEqualsToCurrency_TheFromCurrencyIsReturned() {
		Country country = new Country("GR", "EUR");
		CountryExchangeResult result = currencyExchanger.exchange(country, 100, "EUR");
		assertEquals(country.getIsoCode(), result.getCountryIsoCode());
		assertEquals("EUR", result.getCurrency());
	}

	@Test
	public void exchange_whenThereIsExchangeRate_itIsExchanged() {
		String eurToTRYExchangeRate = "7.43116";
		when(currencyProvider.getCurrencyExcangeRate("EUR", "TRY"))
		.thenReturn(new BigDecimal(eurToTRYExchangeRate));
		Country country = new Country("TR", "TRY");
		CountryExchangeResult result = currencyExchanger.exchange(country, 100, "EUR");
		assertEquals(country.getIsoCode(), result.getCountryIsoCode());
		assertEquals("TRY", result.getCurrency());
		String tryExchangedValue = "743.12";
		assertEquals(new BigDecimal(tryExchangedValue), result.getAmount());
	}

}
