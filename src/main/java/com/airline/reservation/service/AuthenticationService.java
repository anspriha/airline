package com.airline.reservation.service;

import java.util.HashSet;
import java.util.Set;
import jakarta.transaction.Transactional;
import com.airline.reservation.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.airline.reservation.repository.UserRepo;

@Service
public class AuthenticationService implements UserDetailsService{
	
	@Autowired
	private UserRepo userRepo;


	@Override
	@Transactional
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		System.out.println("userName:"+userName);
		User user = userRepo.findByUserName(userName);
		System.out.println("user:"+user);
		Set<SimpleGrantedAuthority> grantedAuthorities = new HashSet<>();
		grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_USER"));
		return new org.springframework.security.core.userdetails.User(user.getUserName(),
				user.getPassword(), grantedAuthorities);
	}

}
