package com.airline.reservation.entity;

import jakarta.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "passenger")
public class Passenger {

	@Id
	@GeneratedValue
	private long passengerId;

	private String emailAddress;

	private String firstName;

	private String gender;

	private String lastName;

	private long mobileNumber;

	private long bookingId;
	
	@OneToOne(cascade =  CascadeType.ALL)
	@JoinColumn(name="checkinId")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
	private Checkin checkIn;
	
	public Passenger() {
		
	}
	
	
	public Passenger(String emailAddress, String firstName, String gender, String lastName,
			long mobileNumber, long bookingId, Checkin checkIn) {
		super();
		this.emailAddress = emailAddress;
		this.firstName = firstName;
		this.gender = gender;
		this.lastName = lastName;
		this.mobileNumber = mobileNumber;
		this.bookingId = bookingId;
		this.checkIn = checkIn;
	}


	public void setBookingId(long bookingId) {
		this.bookingId = bookingId;
	}
	
	public long getBookingId() {
		return bookingId;
	}

	public long getPassengerId() {
		return passengerId;
	}

	public void setPassengerId(long passengerId) {
		this.passengerId = passengerId;
	}
/*
	public BookingRecord getBookingRecord() {
		return bookingRecord;
	}

	public void setBookingRecord(BookingRecord bookingRecord) {
		this.bookingRecord = bookingRecord;
	} */

	public String getEmailAddress() {
		return emailAddress;
	}
	
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	
	public Checkin getCheckIn() {
		return checkIn;
	}
	public void setCheckIn(Checkin checkIn) {
		this.checkIn = checkIn;
	}
	

	@Override
	public String toString() {
		return "Passenger [passengerId=" + passengerId + ", emailAddress=" + emailAddress + ", firstName=" + firstName
				+ ", gender=" + gender + ", lastName=" + lastName + ", mobileNumber=" + mobileNumber
				+ "]";
	}


}
