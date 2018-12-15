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
	
	@PutMapping("/package")
	public ResponseEntity<String> putPackage(@RequestBody Package ppackage) {
		repository.save(ppackage);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/package")
	public ResponseEntity<String> deletePackage(@RequestBody Package ppackage) {
		repository.delete(ppackage);
		return new ResponseEntity<>(HttpStatus.MOVED_PERMANENTLY);
	}
	
	@GetMapping("/package")
	public List<Package> getPackage() {
		List<Package> packages = repository.findAll();
		return packages;
	}
	
	@GetMapping("/package/{id}")
	public Package getPackageById(@PathVariable("id") String id) {
		try {
			System.out.println(id);
			Package pack = repository.findById(id).get();
			return pack;
		} catch(NoSuchElementException e) {
			return null;
		}
	}
	
}
