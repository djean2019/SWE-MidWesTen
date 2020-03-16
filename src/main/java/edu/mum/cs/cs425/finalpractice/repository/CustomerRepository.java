package edu.mum.cs.cs425.finalpractice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.mum.cs.cs425.finalpractice.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
