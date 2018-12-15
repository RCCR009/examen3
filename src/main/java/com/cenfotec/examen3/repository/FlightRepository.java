package com.cenfotec.examen3.repository;

import java.time.LocalDateTime;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.cenfotec.examen3.models.Flight;

public interface FlightRepository extends MongoRepository<Flight, String>{
	@Query("{'date': {$gte: ?0, $lte:?1 }}")
	public Flight findByDateBetween(LocalDateTime startTime, LocalDateTime endTime);
}

