/**
Assignment 2: Class Bank Account

This program simulates a pseudo bank account that starts with a balance of zero.
The class allows a deposit and withdraw on the bank account. It can also display
the current balance of the account. The overdraft amount is checked when
withdrawing and can be set by the user.

Student: Ezra Guia, Wild Guevara, Brandon Fisher, Mark Tremblay
Professor: Leanne Wu
2018-01-31
*/

public class BankAccount {

	private double balance = 0.0;
	private double overdraftAmount = 100.0;
	private String errorMessage = "Error";

	public void deposit (double depositVal) {

		if (depositVal < 0)
			System.out.println(errorMessage);
		else
			balance += depositVal;
		// This conditional statement will check if the deposit being entered
		// is a negative value, which doesn't work for deposits.
	}
	public void withdraw (double withdrawVal) {

		if ((withdrawVal < 0) || ((balance - withdrawVal) < -overdraftAmount))
			System.out.println(errorMessage);
		// Checks if withdrawVal is negative and doesn't go over the set
		// overdraft amount.
	
		else
			balance -= withdrawVal;
		// Only checking for overdraft when withdrawing because you can't
		// overdraft when depositing.
	}
	public double getBalance () {
		
		return balance;	
	}
	public void setOverdraftAmount(double newODAmount) {
		
		overdraftAmount = newODAmount;
	}
}