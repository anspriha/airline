package com.airline.reservation.service;

import com.airline.reservation.entity.AirlineInfo;
import com.airline.reservation.repository.AirlineInfoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AirlineInfoService {
	
	@Autowired
	private AirlineInfoRepo airlineInfoRepo;
	

	public AirlineInfo findByNameOfAirline(String name) {

		return airlineInfoRepo.findByNameOfAirline(name);
	}

}
