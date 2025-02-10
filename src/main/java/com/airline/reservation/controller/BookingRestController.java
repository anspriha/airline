package com.airline.reservation.controller;

import com.airline.reservation.entity.BookingDetails;
import com.airline.reservation.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class BookingRestController {
	@Autowired
	private BookingService bookingService;

	@PostMapping("/bookFlight")
	public ResponseEntity<String> bookFlight(@RequestBody BookingDetails bookingDetails) {
		bookingService.bookFlight(bookingDetails);
		return ResponseEntity.ok("Your Booking is Successful!");
	}

}
