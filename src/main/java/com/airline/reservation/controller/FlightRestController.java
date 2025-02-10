package com.airline.reservation.controller;

import com.airline.reservation.entity.Flight;
import com.airline.reservation.service.FlightService;
import com.airline.reservation.search.SearchCriteria;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class FlightRestController {

	@Autowired
	private FlightService flightService;

	@RequestMapping(value = "/searchFlights", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public List<Flight> searchFlights(@RequestBody SearchCriteria searchcriteria) {
		LocalDate flightDate = Instant.ofEpochMilli(searchcriteria.getFlightDate().getTime())
				.atZone(ZoneId.systemDefault()).toLocalDate();
		List<Flight> flights = flightService.getFlightsByOriginAndDestinationAndFlightDate(
				searchcriteria.getOrigin(), searchcriteria.getDestination(), flightDate);
		return flights;
	}

}
