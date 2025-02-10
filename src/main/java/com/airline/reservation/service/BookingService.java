package com.airline.reservation.service;

import com.airline.reservation.entity.*;
import com.airline.reservation.repository.BookingRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookingService {

	@Autowired
	private BookingRepo bookingRepo;

	@Autowired
	private PassengerService passengerService;

	@Autowired
	private FlightService flightService;

	@Autowired
	private UserService userService;

	@Transactional
	public void bookFlight(BookingDetails record) {

		List<Passenger> passengersList = new ArrayList<>();

		record.getPassengers().forEach(passenger -> {
			if (!StringUtils.isEmpty(passenger.getFirstName()) && !StringUtils.isEmpty(passenger.getLastName())
					&& !StringUtils.isEmpty(passenger.getGender())
					&& !StringUtils.isEmpty(passenger.getMobileNumber())) {
				passengersList.add(passenger);
			}
		});

		FlightDetail flightDetail=record.getBookFlight();
		BookingRecord bookingRecord = new BookingRecord(LocalDateTime.now(), flightDetail.getDestination(), flightDetail.getFare(),
				flightDetail.getFlightDate(), flightDetail.getFlightNumber(), flightDetail.getFlightTime(), flightDetail.getOrigin(), "Booked",
				passengersList);

		System.out.println(bookingRecord);
		BookingRecord bookingRecordFromDB = bookingRepo.save(bookingRecord);

		passengersList.forEach(passenger -> {
			passenger.setBookingId(bookingRecordFromDB.getBookingId());
			passenger.setCheckIn(new Checkin(null, null));
			passengerService.save(passenger);
		});

		Flight flight = flightService.findByFlightNumberAndFlightDateAndFlightTime(flightDetail.getFlightNumber(),
				flightDetail.getFlightDate(), flightDetail.getFlightTime());
		flightService.saveFlight(flight);
		//return bookingRecord;
	}

}
