package com.cenfotec.examen3.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cenfotec.examen3.models.Flight;

public interface FlightRepository extends MongoRepository<Flight, String>{
}

