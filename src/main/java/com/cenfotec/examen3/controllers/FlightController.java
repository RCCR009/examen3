package com.cenfotec.examen3.controllers;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cenfotec.examen3.models.Flight;
import com.cenfotec.examen3.repository.FlightRepository;

@RestController
public class FlightController {
	
	@Autowired
	private FlightRepository repository;

	@PostMapping("/flight")
	public ResponseEntity<String> postAccount(@RequestBody Flight flight) {
		repository.save(flight);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@PutMapping("/flight")
	public ResponseEntity<String> putAccount(@RequestBody Flight flight) {
		repository.save(flight);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/flight")
	public ResponseEntity<String> deleteAccount(@RequestBody Flight flight) {
		repository.delete(flight);
		return new ResponseEntity<>(HttpStatus.MOVED_PERMANENTLY);
	}
	
	@GetMapping("/flight")
	public List<Flight> getAccount() {
		List<Flight> flight = repository.findAll();
		return flight;
	}
	
	@GetMapping("/flight/{id}")
	public Flight getFlightById(@PathVariable("id") String id) {
		try {
			System.out.println(id);
			Flight flight = repository.findById(id).get();
			return flight;
		} catch(NoSuchElementException e) {
			return null;
		}
	}
	
	@GetMapping("/flight/nextFlight")
	public Flight getNextFlight() {
		try {
			Flight flight = repository.findByDateBetween(LocalDate.now().atStartOfDay(), LocalDate.now().atTime(23, 59));
			return flight;
		} catch(NoSuchElementException e) {
			return null;
		}
	}
	
}
