package com.admin;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookFlightRepository extends MongoRepository<BookFlight,String>{

}
