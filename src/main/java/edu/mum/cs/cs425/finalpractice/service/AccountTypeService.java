package edu.mum.cs.cs425.finalpractice.service;

import java.util.List;

import edu.mum.cs.cs425.finalpractice.model.AccountType;

public interface AccountTypeService {
	public abstract List<AccountType> getAllAccountType();
	public abstract AccountType getAccountTypeById(int id);
	public abstract void save(AccountType at);
}
