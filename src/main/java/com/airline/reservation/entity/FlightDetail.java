package com.airline.reservation.entity;

import java.time.LocalDate;
import java.time.LocalTime;

public class FlightDetail {

    private String destination;
    private int fare;
    private LocalDate flightDate;
    private String flightNumber;
    private LocalTime flightTime;
    private String origin;

    // Getters and Setters
    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getFare() {
        return fare;
    }

    public void setFare(int fare) {
        this.fare = fare;
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

    // Constructor
    public FlightDetail(String destination, int fare, LocalDate flightDate, String flightNumber, LocalTime flightTime, String origin) {
        this.destination = destination;
        this.fare = fare;
        this.flightDate = flightDate;
        this.flightNumber = flightNumber;
        this.flightTime = flightTime;
        this.origin = origin;
    }

    // Default constructor (necessary for Jackson)
    public FlightDetail() {
    }

    @Override
    public String toString() {
        return "FlightDetail{" +
                "destination='" + destination + '\'' +
                ", fare=" + fare +
                ", flightDate=" + flightDate +
                ", flightNumber='" + flightNumber + '\'' +
                ", flightTime=" + flightTime +
                ", origin='" + origin + '\'' +
                '}';
    }
}
