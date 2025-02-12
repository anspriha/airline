package com.airline.reservation.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;


public class BookingDetails{

	@JsonProperty("bookFlight")
	private FlightDetail bookFlight;
    private List<Passenger> passengers;

	private BookingDetails bookingDetails;

	private PaymentDetails paymentDetails;


	public PaymentDetails getPaymentDetails() {
		return paymentDetails;
	}

	public void setPaymentDetails(PaymentDetails paymentDetails) {
		this.paymentDetails = paymentDetails;
	}

	public BookingDetails getBookingDetails() {
		return bookingDetails;
	}

	public void setBookingDetails(BookingDetails bookingDetails) {
		this.bookingDetails = bookingDetails;
	}

	public FlightDetail getBookFlight() {
		return bookFlight;
	}

	public void setBookFlight(FlightDetail bookFlight) {
		this.bookFlight = bookFlight;
	}

	public List<Passenger> getPassengers() {
		return passengers;
	}

	public void setPassengers(List<Passenger> passengers) {
		this.passengers = passengers;
	}

}
