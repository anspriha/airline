package com.airline.reservation.controller;

import com.airline.reservation.entity.BookingDetails;
import com.airline.reservation.service.BookingService;
import com.airline.reservation.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class BookingRestController {
	@Autowired
	private BookingService bookingService;

	@Autowired
	private PaymentService paymentService;

	@PostMapping("/bookFlight")
	public ResponseEntity<String> bookFlight(@RequestBody BookingDetails bookingDetails) {

		boolean paymentSuccess = paymentService.processPayment(bookingDetails.getPaymentDetails());

		if (paymentSuccess) {
			// Step 2: Proceed with booking if payment is successful
			bookingService.bookFlight(bookingDetails.getBookingDetails());
			return ResponseEntity.ok("Your Booking is Successful and Payment Confirmed.");
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Payment Failed! Please try again.");
		}
	}

}
