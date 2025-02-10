package com.airline.reservation.service;

import com.airline.reservation.entity.Passenger;
import com.airline.reservation.repository.PassengerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PassengerService {
	
	@Autowired
	private PassengerRepo passengerRepo;

	public void save(Passenger passenger) {
		passengerRepo.save(passenger);
	}

}
