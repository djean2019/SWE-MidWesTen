package edu.mum.cs.cs425.finalpractice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.cs.cs425.finalpractice.model.Account;
import edu.mum.cs.cs425.finalpractice.repository.AccountRepository;
import edu.mum.cs.cs425.finalpractice.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService{
	@Autowired
	private AccountRepository accountRepository;
	

	@Override
	public List<Account> getAllAccount() {
		return accountRepository.findAll();
	}

	@Override
	public Account getAccountById(long id) {
		return accountRepository.findById(id).orElse(null);
	}

	@Override
	public void save(Account account) {
		accountRepository.save(account);
	}

	@Override
	public double computeNetLiquidity() {
		List<Account> accounts = accountRepository.findAll();
		double netLiquidity=0.0;
		for(Account a:accounts) {
			String sA=a.getAccountType().getAccountTypeName();
			if(sA.equals("Savings")||sA.equals("Checking")) {
				netLiquidity+=a.getBalance();
			}
			else if(sA.equals("Loan")) {
				netLiquidity-=a.getBalance();
			}
		}
		return netLiquidity;
	}
	
}
