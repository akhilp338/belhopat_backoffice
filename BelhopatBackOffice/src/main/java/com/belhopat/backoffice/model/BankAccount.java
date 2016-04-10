package com.belhopat.backoffice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class BankAccount {

	@Id
	@GeneratedValue
	private Long id;
	
	private String accountNo;
	
	private String IFSCCode;
	
	private String accountHolderName;
	
	private String bankName;
	
	private String branch;
	
	@OneToOne
	private Address bankAddress;

	public BankAccount(Long id, String accountNo, String iFSCCode, String accountHolderName, String bankName,
			String branch, Address bankAddress) {
		super();
		this.id = id;
		this.accountNo = accountNo;
		IFSCCode = iFSCCode;
		this.accountHolderName = accountHolderName;
		this.bankName = bankName;
		this.branch = branch;
		this.bankAddress = bankAddress;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public String getIFSCCode() {
		return IFSCCode;
	}

	public void setIFSCCode(String iFSCCode) {
		IFSCCode = iFSCCode;
	}

	public String getAccountHolderName() {
		return accountHolderName;
	}

	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public Address getBankAddress() {
		return bankAddress;
	}

	public void setBankAddress(Address bankAddress) {
		this.bankAddress = bankAddress;
	}

	@Override
	public String toString() {
		return "BankAccount [id=" + id + ", accountNo=" + accountNo + ", IFSCCode=" + IFSCCode + ", accountHolderName="
				+ accountHolderName + ", bankName=" + bankName + ", branch=" + branch + ", bankAddress=" + bankAddress
				+ "]";
	}
	
}
