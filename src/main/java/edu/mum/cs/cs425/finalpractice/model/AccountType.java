package edu.mum.cs.cs425.finalpractice.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="accounttypes")
public class AccountType {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int accountTypeId;
	private String accountTypeName;
	@OneToMany(mappedBy="accountType", cascade=CascadeType.ALL)
	private List<Account> accounts;
	
	public AccountType() {
	}

	public AccountType(int accountTypeId, String accountTypeName) {
		this.accountTypeId = accountTypeId;
		this.accountTypeName = accountTypeName;
	}

	public int getAccountTypeId() {
		return accountTypeId;
	}

	public void setAccountTypeId(int accountTypeId) {
		this.accountTypeId = accountTypeId;
	}

	public String getAccountTypeName() {
		return accountTypeName;
	}

	public void setAccountTypeName(String accountTypeName) {
		this.accountTypeName = accountTypeName;
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}
	
	
}
