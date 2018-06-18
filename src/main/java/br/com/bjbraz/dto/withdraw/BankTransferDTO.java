package br.com.bjbraz.dto.withdraw;

import java.io.Serializable;

public class BankTransferDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8960739238093994470L;
	
	private String bankDestination;
	private String branchDestination;
	private String accountDestination;
	private String personType;
	private String name;
	private String accountTypeDestination;
	
	
	private TaxIdentifierDTO taxIdentifier;

	public String getBankDestination() {
		return bankDestination;
	}

	public void setBankDestination(String bankDestination) {
		this.bankDestination = bankDestination;
	}

	public String getBranchDestination() {
		return branchDestination;
	}

	public void setBranchDestination(String branchDestination) {
		this.branchDestination = branchDestination;
	}

	public String getAccountDestination() {
		return accountDestination;
	}

	public void setAccountDestination(String accountDestination) {
		this.accountDestination = accountDestination;
	}

	public TaxIdentifierDTO getTaxIdentifier() {
		return taxIdentifier;
	}

	public void setTaxIdentifier(TaxIdentifierDTO taxIdentifier) {
		this.taxIdentifier = taxIdentifier;
	}

	public String getPersonType() {
		return personType;
	}

	public void setPersonType(String personType) {
		this.personType = personType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAccountTypeDestination() {
		return accountTypeDestination;
	}

	public void setAccountTypeDestination(String accountTypeDestination) {
		this.accountTypeDestination = accountTypeDestination;
	}
	
}
