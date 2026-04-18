package com.hasagj.acts.repository;

import com.hasagj.acts.model.Contractors;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContractorsRepository extends MongoRepository<Contractors, String> {

}