package com.airline.reservation;

import java.text.ParseException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class AirlineApplication {

	public static void main(String[] args) throws ParseException {

		ApplicationContext ac = SpringApplication.run(AirlineApplication.class, args);
	}
}
