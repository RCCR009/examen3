package com.cenfotec.examen3.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cenfotec.examen3.models.Courier;

public interface CourierRepository extends MongoRepository< Courier, String> {

}