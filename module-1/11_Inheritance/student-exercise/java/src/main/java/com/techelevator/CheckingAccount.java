package com.techelevator;

public class CheckingAccount extends BankAccount {

	private int overDraftFee = 10;
	
	public int getOverDraftFee() {
		return overDraftFee;
	}
	
	public CheckingAccount(String accountHolderName, String accountNumber, int balance) {
		super(accountHolderName, accountNumber, balance);	
	}
	
	public CheckingAccount(String accountHolderName, String accountNumber) {
		super(accountHolderName, accountNumber);
	}
	
	@Override
	public int withdraw(int amountToWithdraw) {
		if(getBalance() - amountToWithdraw >= 0) {
			return super.withdraw(amountToWithdraw);
		}
		if((getBalance() - amountToWithdraw) < 0 && (getBalance() - amountToWithdraw) > (-100)) {
		  return (super.withdraw(amountToWithdraw + overDraftFee));
		}
			return getBalance();
	}
}