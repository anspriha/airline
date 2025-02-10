package com.airline.reservation.repository;

import com.airline.reservation.entity.BookingRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepo extends JpaRepository<BookingRecord, Long>{

}
