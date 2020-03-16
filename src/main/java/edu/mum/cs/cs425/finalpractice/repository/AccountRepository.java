package edu.mum.cs.cs425.finalpractice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.mum.cs.cs425.finalpractice.model.Account;

public interface AccountRepository extends JpaRepository<Account, Long>{

}
