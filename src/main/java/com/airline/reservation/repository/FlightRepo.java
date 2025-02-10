package com.airline.reservation.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.airline.reservation.entity.Flight;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Repository
public interface FlightRepo extends JpaRepository<Flight, Long> {

    /*@EntityGraph(attributePaths = { "fare", "flightInfo", "flightInfo.airlineInfo" })
    @Query(value = "from Flight f where f.origin= :origin and f.destination= :destination and f.flightDate= :flightDate")
    List<Flight> getFlightsByOriginAndDestinationAndFlightDate(String origin, String destination,
                                                               LocalDate flightDate);*/



    @EntityGraph(attributePaths = { "fare", "flightInfo", "flightInfo.airlineInfo" })
    @Query("from Flight f where f.origin = :origin and f.destination = :destination and f.flightDate = :flightDate")
    List<Flight> getFlightsByOriginAndDestinationAndFlightDate(@Param("origin") String origin,
                                                               @Param("destination") String destination,
                                                               @Param("flightDate") LocalDate flightDate);

    @EntityGraph(attributePaths = { "fare", "flightInfo", "flightInfo.airlineInfo" })
    Flight findByFlightNumberAndFlightDateAndFlightTime(String flightNumber, LocalDate flightDate,
                                                        LocalTime flightTime);


}
