package com.example.demo.providers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.example.demo.model.Country;
import com.example.demo.model.StartingCountry;

@Component
public class NeighbourCountriesProvider {

	//mock data instead of using external rest api for simplicity
	private final Map<String, List<Country>> startingCountries;
	
	{
		Country turkey = new Country("TR", "TRY");
		Country greece = new Country("GR", "EUR");
		Country romania = new Country("RO", "RON");
		Country serbia = new Country("SR", "RSD");
		Country makedonia = new Country("MK", "MKD");
		List<Country> bulgariaNeighbourCountries = new ArrayList<>();
		bulgariaNeighbourCountries.add(turkey);
		bulgariaNeighbourCountries.add(greece);
		bulgariaNeighbourCountries.add(romania);
		bulgariaNeighbourCountries.add(serbia);
		bulgariaNeighbourCountries.add(makedonia);
		startingCountries = new HashMap<>();
		startingCountries.put("BG", bulgariaNeighbourCountries);
	}

	public List<Country> getNeighbourCountries(StartingCountry startingCountry) {
		return startingCountries.get(startingCountry.toString());
	}
	
}
