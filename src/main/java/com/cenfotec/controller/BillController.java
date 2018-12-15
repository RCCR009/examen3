package com.cenfotec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cenfotec.examen3.models.Bill;
import com.cenfotec.repository.BillRepository;

@RestController
public class BillController {
	
	@Autowired
	private BillRepository repository;

	@PostMapping("/bill")
	public ResponseEntity<String> addColleague(@RequestBody Bill bill){
		repository.save(bill);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

}
