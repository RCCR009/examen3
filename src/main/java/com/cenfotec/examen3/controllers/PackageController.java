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
import com.cenfotec.examen3.models.Package;
import com.cenfotec.examen3.repository.FlightRepository;
import com.cenfotec.examen3.repository.PackageRepository;

@RestController
public class PackageController {

	@Autowired
	private PackageRepository repository;
	
	@Autowired
	private FlightRepository flightRepository;

	@PostMapping("/package")
	public ResponseEntity<String> postPackage(@RequestBody Package ppackage) {
		repository.save(ppackage);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@PostMapping("/package/recibirPaquete")
	public ResponseEntity<String> recibirPaquete(@RequestBody Package ppackage) {
		ppackage.setFechaRecibido(LocalDate.now());
		ppackage.setPrealerted(false);
		repository.save(ppackage);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@PostMapping("/package/recibirPrealerta")
	public ResponseEntity<String> recibirPrealerta(@RequestBody Package ppackage) {
		try {
			ppackage.setFechaRecibido(LocalDate.now());
			ppackage.setPrealerted(true);
			if(ppackage.getBill() != null) {
				Package pack = repository.save(ppackage);
				Flight flight = flightRepository.findByDateBetween(LocalDate.now().atStartOfDay(), LocalDate.now().atTime(23, 59));
				flight.addPackage(pack);
				flightRepository.save(flight);
				return new ResponseEntity<>(HttpStatus.CREATED);
			} else {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
		} catch(NoSuchElementException e) {
			return null;
		} catch(NullPointerException e ) {
			return null;
		}
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
	
	@GetMapping("/package/recibidos")
	public List<Package> getPackageByRecibidos() {
		try {
			List<Package> packs = repository.findByPrealerted(false);
			return packs;
		} catch(NoSuchElementException e) {
			return null;
		}
	}
	
	@GetMapping("/package/getByAccount")
	public List<Package> getPackageByRecibidos(String idAccount) {
		try {
			List<Package> packs = repository.findByAccount(idAccount);
			return packs;
		} catch(NoSuchElementException e) {
			return null;
		}
	}
	
}
