/**
Assignment 2: Class Bank Account

This program simulates a pseudo bank account that starts with a balance of zero.
The class allows a deposit and withdraw on the bank account. It can also display
the current balance of the account.

Student: Ezra John Guia
Professor: Leanne Wu
2018-01-31
*/

public class BankAccount {
	private double balance = 0.0;
	private double overdraftAmount = 100.0;

	public void deposit (double depositVal) {

		balance += depositVal;
	}
	public void withdraw (double withdrawVal) {

		if ((balance - withdrawVal) < -overdraftAmount) {
			System.out.println("You are borrowing more than what your account is letting you.");
		}
		else {
			balance -= withdrawVal;
		}
		// Only checking for overdraft when withdrawing because you can't
		// overdraft when depositing.
	}
	public double balance () {
		
		return balance;	
	}
	public void overdraftAmount(double newODAmount) {
		
		overdraftAmount = newODAmount;
	}
}