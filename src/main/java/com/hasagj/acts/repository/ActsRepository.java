package com.hasagj.acts.repository;

import com.hasagj.acts.model.Acts;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActsRepository extends MongoRepository<Acts, String> {

}