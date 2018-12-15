package com.cenfotec.examen3.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cenfotec.examen3.models.Package;

public interface PackageRepository extends MongoRepository<Package, String> {

}
