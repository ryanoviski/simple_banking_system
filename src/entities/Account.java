package entities;

public abstract class Account {
	protected int accountNumber;
	protected String holder;
	protected double balance;

	public Account(int accountNumber, String holder, double initialDeposit) {
		this.accountNumber = accountNumber;
		this.holder = holder;
		this.balance = initialDeposit;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public String getHolder() {
		return holder;
	}

	public double getBalance() {
		return balance;
	}

	public void deposit(double amount) {
		if (amount <= 0) {
			System.out.println("Deposit amount must be positive");
			return;
		}
		balance += amount;
		System.out.println("Deposit successful! New balance: $" + balance);
	}

	public void withdraw(double amount) {
		if (amount <= 0) {
			System.out.println("Withdrawal amount must be positive.");
			return;
		}
		if (amount > balance) {
			throw new RuntimeException("Insufficient balance");
		}
		balance -= amount;
		System.out.println("Withdrawal succesful! New balance: $" + balance);
	}

	@Override
	public String toString() {
		return "Account: " + accountNumber + " | Holder: " + holder + " | Balance: $" + String.format("%.2f", balance);
	}
}