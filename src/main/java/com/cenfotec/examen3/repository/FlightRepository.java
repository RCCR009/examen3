package com.cenfotec.examen3.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cenfotec.examen3.models.Flight;

public interface FlightRepository extends MongoRepository<Flight, String>{

	public List< Flight > findByName(String name);
}

