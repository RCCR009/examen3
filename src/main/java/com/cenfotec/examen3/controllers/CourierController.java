package com.cenfotec.examen3.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cenfotec.examen3.models.Courier;
import com.cenfotec.examen3.repository.CourierRepository;

@RestController
public class CourierController {

	@Autowired
	private CourierRepository repository;

	@PostMapping("/courier")
	public ResponseEntity<String> postPackage(@RequestBody Courier pcourier) {
		repository.save(pcourier);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
}
