package services;

import java.util.HashMap;
import java.util.Map;

import entities.Account;

public class BankingSystem {
	private Map<Integer, Account> accounts = new HashMap<>();

	public void addAccount(Account account) {
		accounts.put(account.getAccountNumber(), account);
	}

	public Account getAccount(int accountNumber) {
		return accounts.get(accountNumber);
	}

	public void transfer(int fromAccount, int toAccount, double amount) {
		Account sender = getAccount(fromAccount);
		Account receiver = getAccount(toAccount);

		if (sender == null || receiver == null) {
			throw new RuntimeException("Invalid account number.");
		}

		sender.withdraw(amount);
		receiver.deposit(amount);
	}

	public void printStatement(int accountNumber) {
		Account acc = getAccount(accountNumber);
		if (acc != null) {
			System.out.println(acc);
		} else {
			System.out.println("Account not found.");
		}
	}
}