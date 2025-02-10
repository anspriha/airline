package com.airline.reservation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airline.reservation.repository.UserRepo;
import com.airline.reservation.entity.User;

@Service
public class UserService {	
	
	@Autowired
	UserRepo userRepo;
	
	public void registerForm(User user) {
		userRepo.save(user);
	}
	
	
	public User findByUserName(String userName){
		return userRepo.findByUserName(userName);
	}

}
