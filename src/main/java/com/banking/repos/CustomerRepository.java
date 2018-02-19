package com.banking.repos;

import com.banking.domains.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Master on 2/19/2018.
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {
    Customer findByEmailAndPassword(String email,String password);
    Customer findByEmail(String email);
}
