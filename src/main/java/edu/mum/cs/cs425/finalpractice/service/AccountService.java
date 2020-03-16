package edu.mum.cs.cs425.finalpractice.service;

import java.util.List;

import edu.mum.cs.cs425.finalpractice.model.Account;

public interface AccountService {
	public abstract List<Account> getAllAccount();
	public abstract Account getAccountById(long id);
	public abstract void save(Account account);
	public abstract double computeNetLiquidity();
}
