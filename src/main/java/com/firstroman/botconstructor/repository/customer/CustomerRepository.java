package com.firstroman.botconstructor.repository.customer;

import com.firstroman.botconstructor.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CustomerRepository extends MongoRepository<Customer, String> {
    List<Customer> findAllByAffiliationId(String affiliationId);
}
