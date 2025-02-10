package com.airline.reservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.airline.reservation.entity.AirlineInfo;

@Repository
public interface AirlineInfoRepo extends JpaRepository<AirlineInfo, Long>{
    AirlineInfo findByNameOfAirline(String name);


}
