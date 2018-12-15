package com.cenfotec.examen3.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cenfotec.examen3.models.Account;

public interface AccountRepository extends MongoRepository< Account, String> {

}