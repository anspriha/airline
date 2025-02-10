package com.airline.reservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.airline.reservation.entity.User;
@Repository
public interface UserRepo extends JpaRepository<User, Long> {
	
	User findByUserName(String userName);

}
