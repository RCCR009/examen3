package com.cenfotec.examen3.controllers;

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

import com.cenfotec.examen3.models.Courier;
import com.cenfotec.examen3.repository.CourierRepository;

@RestController
public class CourierController {

	@Autowired
	private CourierRepository repository;

	@PostMapping("/courier")
	public ResponseEntity<String> postCourier(@RequestBody Courier pcourier) {
		repository.save(pcourier);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@PutMapping("/courier")
	public ResponseEntity<String> putCourier(@RequestBody Courier pcourier) {
		repository.save(pcourier);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/courier")
	public ResponseEntity<String> deleteCourier(@RequestBody Courier pcourier) {
		repository.delete(pcourier);
		return new ResponseEntity<>(HttpStatus.MOVED_PERMANENTLY);
	}
	
	@GetMapping("/courier")
	public List<Courier> getCourier() {
		List<Courier> couriers = repository.findAll();
		return couriers;
	}
	
	@GetMapping("/courier/{id}")
	public Courier getPackageById(@PathVariable("id") String id) {
		try {
			System.out.println(id);
			Courier courier = repository.findById(id).get();
			return courier;
		} catch(NoSuchElementException e) {
			return null;
		}
	}
	
}
