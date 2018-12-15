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

import com.cenfotec.examen3.models.Account;
import com.cenfotec.examen3.repository.AccountRepository;

@RestController
public class AccountController {

	@Autowired
	private AccountRepository repository;

	@PostMapping("/account")
	public ResponseEntity<String> postAccount(@RequestBody Account paccount) {
		repository.save(paccount);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@PutMapping("/account")
	public ResponseEntity<String> putAccount(@RequestBody Account paccount) {
		repository.save(paccount);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/account")
	public ResponseEntity<String> deleteAccount(@RequestBody Account paccount) {
		repository.delete(paccount);
		return new ResponseEntity<>(HttpStatus.MOVED_PERMANENTLY);
	}
	
	@GetMapping("/account")
	public List<Account> getAccount() {
		List<Account> accounts = repository.findAll();
		return accounts;
	}
	
	@GetMapping("/account/{id}")
	public Account getPackageById(@PathVariable("id") String id) {
		try {
			System.out.println(id);
			Account account = repository.findById(id).get();
			return account;
		} catch(NoSuchElementException e) {
			return null;
		}
	}
	
}
