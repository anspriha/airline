package com.airline.reservation.service;

import com.airline.reservation.repository.FlightRepo;
import com.airline.reservation.entity.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
public class FlightService {

	@Autowired
	private FlightRepo flightRepo;


	public List<Flight> getFlightsByOriginAndDestinationAndFlightDate(String origin, String destination,
																	  LocalDate flightDate) {
		return flightRepo.getFlightsByOriginAndDestinationAndFlightDate(origin, destination, flightDate);
	}
	public Flight findByFlightNumberAndFlightDateAndFlightTime(String flightNumber, LocalDate flightDate,
															   LocalTime flightTime) {
		return flightRepo.findByFlightNumberAndFlightDateAndFlightTime(flightNumber, flightDate, flightTime);
	}
	public Flight saveFlight(Flight flight) {
		return flightRepo.save(flight);
	}
}
