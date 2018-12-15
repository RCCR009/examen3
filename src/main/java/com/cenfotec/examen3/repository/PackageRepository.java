package com.cenfotec.examen3.repository;


import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.cenfotec.examen3.models.Package;

public interface PackageRepository extends MongoRepository<Package, String> {
	public List<Package> findByPrealerted(Boolean state);
	
	@Query("{'receiver._id': ?0 }")
	public List<Package> findByAccount(String id);
}
