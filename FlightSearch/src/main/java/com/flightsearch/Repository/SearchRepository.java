package com.flightsearch.Repository;
import com.flightsearch.models.*;



import org.springframework.data.mongodb.repository.MongoRepository;

public interface SearchRepository extends MongoRepository<Search,String>{

	

}
