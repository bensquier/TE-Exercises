package com.techelevator;

public class SavingsAccount extends BankAccount {
	
	private int serviceCharge = 2;

	public int getServiceCharge() {
		return serviceCharge;
	}
	
	public SavingsAccount(String accountHolderName, String accountNumber, int balance) {
		super(accountHolderName, accountNumber, balance);	
	}
	
	public SavingsAccount(String accountHolderName, String accountNumber) {
		super(accountHolderName, accountNumber);
	}
	
	@Override
	public int withdraw(int amountToWithdraw) {
		int newBalance = getBalance() - amountToWithdraw;
		if(newBalance >= 150) {
			return super.withdraw(amountToWithdraw); 
		}	if(newBalance < 150 && newBalance >= 0) {
			return super.withdraw(amountToWithdraw + serviceCharge);
		}
		return getBalance();
	}

}
