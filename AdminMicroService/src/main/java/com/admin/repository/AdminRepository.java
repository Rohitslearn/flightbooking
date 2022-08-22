package com.admin.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.admin.models.*;
@Repository
public interface AdminRepository extends MongoRepository<Admin,String>{

}
