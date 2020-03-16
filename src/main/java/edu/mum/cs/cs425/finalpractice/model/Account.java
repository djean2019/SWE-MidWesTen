package edu.mum.cs.cs425.finalpractice.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="accounts")
public class Account {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long accountId;
	private long accountNumber;
	private double balance;
	@ManyToOne
	@JoinColumn(name="customer", nullable=false)
	private Customer customer;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="account_type", nullable=false)
	private AccountType accountType;
	
	public Account() {
	}

	
	public Account(long accountId, long accountNumber, double balance) {
		this.accountId = accountId;
		this.accountNumber = accountNumber;
		this.balance = balance;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public long getAccountId() {
		return accountId;
	}

	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}

	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}


	public AccountType getAccountType() {
		return accountType;
	}


	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}
	
	
}
