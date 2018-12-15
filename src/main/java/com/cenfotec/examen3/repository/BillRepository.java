package com.cenfotec.examen3.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cenfotec.examen3.models.Bill;

public interface BillRepository extends MongoRepository<Bill, String>{

}
