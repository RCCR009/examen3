package com.cenfotec.examen3.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cenfotec.examen3.models.Account;
import com.cenfotec.examen3.repository.AccountRepository;

@RestController
public class AccountController {

	@Autowired
	private AccountRepository repository;

	@PostMapping("/account")
	public ResponseEntity<String> postPackage(@RequestBody Account paccount) {
		repository.save(paccount);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
}
