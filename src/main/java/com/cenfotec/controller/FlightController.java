package com.cenfotec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cenfotec.examen3.models.Flight;
import com.cenfotec.repository.FlightRepository;

@RestController
public class FlightController {
	
	@Autowired
	private FlightRepository repository;

	@PostMapping("/flight")
	public ResponseEntity<String> addColleague(@RequestBody Flight flight){
		repository.save(flight);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
}
