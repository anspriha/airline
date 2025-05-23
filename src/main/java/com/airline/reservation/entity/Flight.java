package com.airline.reservation.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.*;

@Entity
@Table(name="flight")
public class Flight {
	
	@Id
	@GeneratedValue
	private long id;	

	private String destination;

	private String duration;
	
	private LocalDate flightDate;
	
	private String flightNumber;
	
	private LocalTime flightTime; 

	private String origin;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fareId")
	private Fare fare;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="flightInfoid")
	private FlightInfo flightInfo;

	public Flight() {
		
	}

	public Flight(String destination, String duration, LocalDate flightDate, String flightNumber, LocalTime flightTime,
			String origin, Fare fare, FlightInfo flightInfo) {
		super();
		this.destination = destination;
		this.duration = duration;
		this.flightDate = flightDate;
		this.flightNumber = flightNumber;
		this.flightTime = flightTime;
		this.origin = origin;
		this.fare = fare;
		this.flightInfo = flightInfo;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public LocalDate getFlightDate() {
		return flightDate;
	}

	public void setFlightDate(LocalDate flightDate) {
		this.flightDate = flightDate;
	}

	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	public LocalTime getFlightTime() {
		return flightTime;
	}

	public void setFlightTime(LocalTime flightTime) {
		this.flightTime = flightTime;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public Fare getFare() {
		return fare;
	}

	public void setFare(Fare fare) {
		this.fare = fare;
	}

	public FlightInfo getFlightInfo() {
		return flightInfo;
	}

	public void setFlightInfo(FlightInfo flightInfo) {
		this.flightInfo = flightInfo;
	}

	
	@Override
	public String toString() {
		return "Flight [id=" + id +
				", destination=" + destination +
				", duration=" + duration +
				", flightDate=" + flightDate +
				", flightNumber=" + flightNumber +
				", flightTime=" + flightTime +
				", origin=" + origin +
				", fare=" + fare +
				", flightInfo=" + flightInfo + "]";
	}

}
