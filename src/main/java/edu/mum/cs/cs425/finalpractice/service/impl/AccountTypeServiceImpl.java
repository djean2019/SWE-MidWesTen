package edu.mum.cs.cs425.finalpractice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.cs.cs425.finalpractice.model.AccountType;
import edu.mum.cs.cs425.finalpractice.repository.AccountTypeRepository;
import edu.mum.cs.cs425.finalpractice.service.AccountTypeService;

@Service
public class AccountTypeServiceImpl implements AccountTypeService{

	@Autowired
	private AccountTypeRepository atRepository;
	
	@Override
	public List<AccountType> getAllAccountType() {
		return atRepository.findAll();
	}

	@Override
	public AccountType getAccountTypeById(int id) {
		return atRepository.findById(id).orElse(null);
	}

	@Override
	public void save(AccountType at) {
		atRepository.save(at);
	}

}
