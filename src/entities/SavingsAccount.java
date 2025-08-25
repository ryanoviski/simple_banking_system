package entities;

public class SavingsAccount extends Account {
	private static final double INTEREST_RATE = 0.02;

	public SavingsAccount(int accountNumber, String holder, double initialDeposit) {
		super(accountNumber, holder, initialDeposit);
	}

	public void applyInterest() {
		balance += balance * INTEREST_RATE;
	}
}