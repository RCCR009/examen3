package com.cenfotec.examen3.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cenfotec.examen3.models.Package;
import com.cenfotec.examen3.repository.PackageRepository;

@RestController
public class PackageController {

	@Autowired
	private PackageRepository repository;

	@PostMapping("/package")
	public ResponseEntity<String> postPackage(@RequestBody Package ppackage) {
		repository.save(ppackage);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
}
