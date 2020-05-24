package com.example.demo.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.demo.service.NeighbourCountriesCalculateTripService;

@RunWith(MockitoJUnitRunner.class)
public class NeighbourCountriesCalculateTripControllerTest {
	
	@Mock
	private NeighbourCountriesCalculateTripService neighbourCountriesCalculateTripService;
	
	@InjectMocks
	private NeighbourCountriesCalculateTripController neighbourCountriesCalculateTripController;
	
	private MockMvc mockMvc;
	
	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.standaloneSetup(neighbourCountriesCalculateTripController).build();
	}
	
	@Test
	public void calculateTrips_whenThereIsNoTotalBudget_returnedStatusIsBadRequest() throws Exception {
		 mockMvc.perform(get("/calculate/BG?countryBudget=200&currency=EUR")
				 .accept(MediaType.APPLICATION_JSON))
		 .andExpect(status().isBadRequest());
	}
	
	@Test
	public void calculateTrips_whenThereIsNoCountryBudget_returnedStatusIsBadRequest() throws Exception {
		 mockMvc.perform(get("/calculate/BG?totalBudget=200&currency=EUR")
				 .accept(MediaType.APPLICATION_JSON))
		 .andExpect(status().isBadRequest());
	}
	
	@Test
	public void calculateTrips_whenThereIsNoCurrency_returnedStatusIsBadRequest() throws Exception {
		 mockMvc.perform(get("/calculate/BG?countryBudget=200&totalBudget=1200")
				 .accept(MediaType.APPLICATION_JSON))
		 .andExpect(status().isBadRequest());
	}
	
	@Test
	public void calculateTrips_whenStartingCountryIsNotPresent_returnedStatusIsNotFound() throws Exception {
		 mockMvc.perform(get("/calculate/?totalBudget=1200&countryBudget=200&currency=EU")
				 .accept(MediaType.APPLICATION_JSON))
		 .andExpect(status().isNotFound());
	}
	
	@Test
	public void calculateTrips_whenStartingCountryIsNotInTheList_returnedStatusIsBadRequest() throws Exception {
		 mockMvc.perform(get("/calculate/BR?totalBudget=1200&countryBudget=200&currency=EU")
				 .accept(MediaType.APPLICATION_JSON))
		 .andExpect(status().isBadRequest());
	}
	
	@Test
	public void calculateTrips_whenAllValidationsPass_thereIsResult() throws Exception {
		 mockMvc.perform(get("/calculate/BG?totalBudget=200&countryBudget=200&currency=EUR")
				 .accept(MediaType.APPLICATION_JSON))
		 .andExpect(status().isOk());
	}
}
