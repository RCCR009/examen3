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

import com.cenfotec.examen3.models.Bill;
import com.cenfotec.examen3.models.Flight;
import com.cenfotec.examen3.models.Package;
import com.cenfotec.examen3.repository.BillRepository;
import com.cenfotec.examen3.repository.FlightRepository;
import com.cenfotec.examen3.repository.PackageRepository;

@RestController
public class BillController {
	
	@Autowired
	private BillRepository repository;
	
	@Autowired
	private PackageRepository packRepository;
	
	@Autowired
	private FlightRepository flightRepository;

	@PostMapping("/bill")
	public ResponseEntity<String> postAccount(@RequestBody Bill bill) {
		repository.save(bill);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@PostMapping("/bill/presentarFactura")
	public ResponseEntity<String> presentarFactura(@RequestBody Bill bill, String idPaquete) {
		try {
			Package pack = packRepository.findById(idPaquete).get();
			Bill doc = repository.save(bill);
			pack.setBill(doc);
			packRepository.save(pack);
			Flight flight = flightRepository.findByDateBetween(LocalDate.now().atStartOfDay(), LocalDate.now().atTime(23, 59));
			flight.addPackage(pack);
			flightRepository.save(flight);
			return new ResponseEntity<>(HttpStatus.CREATED);
		} catch(NoSuchElementException e) {
			return null;
		} catch(NullPointerException e ) {
			return null;
		}
	}
	
	@PutMapping("/bill")
	public ResponseEntity<String> putAccount(@RequestBody Bill bill) {
		repository.save(bill);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/bill")
	public ResponseEntity<String> deleteAccount(@RequestBody Bill bill) {
		repository.delete(bill);
		return new ResponseEntity<>(HttpStatus.MOVED_PERMANENTLY);
	}
	
	@GetMapping("/bill")
	public List<Bill> getAccount() {
		List<Bill> bill = repository.findAll();
		return bill;
	}
	
	@GetMapping("/bill/{id}")
	public Bill getPackageById(@PathVariable("id") String id) {
		try {
			System.out.println(id);
			Bill bill = repository.findById(id).get();
			return bill;
		} catch(NoSuchElementException e) {
			return null;
		}
	}

}
