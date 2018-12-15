package com.cenfotec.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cenfotec.examen3.models.Bill;

public interface BillRepository extends MongoRepository<Bill, String>{
	public List< Bill > findByName(String name);

}
