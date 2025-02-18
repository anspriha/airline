package com.airline.reservation.config;


import com.airline.reservation.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Autowired
	AuthenticationService authenticationService;

	@Bean
	public AuthenticationManager authManager(HttpSecurity http) throws Exception {
		// Use the AuthenticationManagerBuilder to configure the AuthenticationManager directly
		AuthenticationManagerBuilder authenticationManagerBuilder =
				http.getSharedObject(AuthenticationManagerBuilder.class);

		authenticationManagerBuilder
				.userDetailsService(authenticationService)
				.passwordEncoder(bCryptPasswordEncoder());

		return authenticationManagerBuilder.build();
	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

		http
				.csrf(csrf -> csrf.disable()) // Disable CSRF protection api/searchFlights
				.authorizeHttpRequests(authorize -> authorize
						.requestMatchers("/v3/api-docs/**","/swagger-ui.html","/swagger-ui/**","/api/login", "/api/register", "/api/searchFlights", "/api/bookFlight").permitAll() // Allow access to the custom /login endpoint
						.anyRequest().authenticated() // Require authentication for other endpoints
				);
		return http.build();

	}


}
