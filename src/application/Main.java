package application;

import java.util.Scanner;

import entities.Account;
import entities.CheckingAccount;
import entities.SavingsAccount;
import services.BankingSystem;

public class Main {
	private static final Scanner scanner = new Scanner(System.in);
	private static final BankingSystem bankingSystem = new BankingSystem();

	public static void main(String[] args) {
		boolean running = true;
		while (running) {
			printMenu();
			int option = readInt("Choose an option: ");
			try {
				switch (option) {
				case 1 -> createAccount();
				case 2 -> deposit();
				case 3 -> withdraw();
				case 4 -> transfer();
				case 5 -> viewStatement();
				case 6 -> {
					System.out.println("Exiting system. Goodbye!");
					running = false;
				}
				default -> System.out.println("Invalid option.");
				}
			} catch (RuntimeException e) {
				System.out.println("Error: " + e.getMessage());
			}
		}
		scanner.close();
	}

	private static void printMenu() {
		System.out.println("\n--- Banking System Menu ---");
		System.out.println("1. Create account");
		System.out.println("2. Deposit");
		System.out.println("3. Withdraw");
		System.out.println("4. Transfer");
		System.out.println("5. View statement");
		System.out.println("6. Exit");
	}

	private static void createAccount() {
		int accNum = readInt("Enter account number: ");
		System.out.print("Enter holder name: ");
		String holder = scanner.nextLine();
		double initialDeposit = readDouble("Enter initial deposit: ");
		System.out.print("Account type (1-Checking, 2-Savings): ");
		int type = readInt("");

		Account acc;
		if (type == 1) {
			acc = new CheckingAccount(accNum, holder, initialDeposit);
		} else if (type == 2) {
			acc = new SavingsAccount(accNum, holder, initialDeposit);
		} else {
			throw new RuntimeException("Invalid account type.");
		}

		bankingSystem.addAccount(acc);
		System.out.println("Account created successfully!");
	}

	private static void deposit() {
		int accNum = readInt("Enter account number: ");
		double amount = readDouble("Enter amount to deposit: ");
		Account acc = bankingSystem.getAccount(accNum);
		if (acc != null) {
			acc.deposit(amount);
			System.out.println("Deposit successful!");
		} else {
			System.out.println("Account not found.");
		}
	}

	private static void withdraw() {
		int accNum = readInt("Enter account number: ");
		double amount = readDouble("Enter amount to withdraw: ");
		Account acc = bankingSystem.getAccount(accNum);
		if (acc != null) {
			acc.withdraw(amount);
			System.out.println("Withdrawal successful!");
		} else {
			System.out.println("Account not found.");
		}
	}

	private static void transfer() {
		int from = readInt("Enter source account number: ");
		int to = readInt("Enter destination account number: ");
		double amount = readDouble("Enter amount to transfer: ");
		bankingSystem.transfer(from, to, amount);
		System.out.println("Transfer completed!");
	}

	private static void viewStatement() {
		int accNum = readInt("Enter account number: ");
		bankingSystem.printStatement(accNum);
	}

	// Helper methods for input
	private static int readInt(String prompt) {
		while (true) {
			try {
				System.out.print(prompt);
				return Integer.parseInt(scanner.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("Invalid number, please enter an integer.");
			}
		}
	}

	private static double readDouble(String prompt) {
		while (true) {
			try {
				System.out.print(prompt);
				return Double.parseDouble(scanner.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("Invalid number, try again.");
			}
		}
	}
}