package com.example.demo.controller;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.CalculationResult;
import com.example.demo.model.StartingCountry;
import com.example.demo.service.NeighbourCountriesCalculateTripService;

@RestController("neighbourcountries")
@Validated
public class NeighbourCountriesCalculateTripController {
	
	private NeighbourCountriesCalculateTripService neighbourCountriesService;
	
	@Autowired
	public NeighbourCountriesCalculateTripController(NeighbourCountriesCalculateTripService neighbourCountriesTripService) {
		this.neighbourCountriesService = neighbourCountriesTripService;
	}
	
	@GetMapping("/calculate/{startingCountry}")
	public CalculationResult calculateTrips(@NotNull @PathVariable("startingCountry") StartingCountry startingCountry,
			@RequestParam int totalBudget, @RequestParam int countryBudget, @Size(max = 3, min = 3) @RequestParam String currency) {
		return neighbourCountriesService.calculateNeighbourTrips(startingCountry, totalBudget, countryBudget, currency.toUpperCase());
	}
}