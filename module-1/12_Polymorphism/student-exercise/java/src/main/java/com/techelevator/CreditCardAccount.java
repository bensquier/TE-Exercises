package com.techelevator;

public class CreditCardAccount implements Accountable {
	
	private int debt;
	private String accountHolder;
	private String accountNumber;


	public CreditCardAccount(String accountHolder, String accountNumber) {
		this.debt = 0;
		this.accountHolder = accountHolder;
		this.accountNumber = accountNumber;
	
	}
	
	public String getAccountHolder() {
		return this.accountHolder;
	}

	public String getAccountNumber() {
		return this.accountNumber;
	}
	public int getDebt() {
		return debt;
	}
	
	public int getBalance() {
		return -debt;
	}
	
	public int pay(int amountToPay) {
		this.debt = debt - amountToPay;
		return debt;
	}
	
	public int charge(int amountToCharge) {
		this.debt = debt + amountToCharge;
		return debt;
	}
	
	
	
	
	
	

	
	}


