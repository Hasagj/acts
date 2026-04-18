package com.hasagj.acts.repository;

import com.hasagj.acts.model.Services;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicesRepository extends MongoRepository<Services, String> {

}