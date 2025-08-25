package entities;

public class CheckingAccount extends Account {
	private static final double WITHDRAW_FEE = 2.0;

	public CheckingAccount(int accountNumber, String holder, double initialDeposit) {
		super(accountNumber, holder, initialDeposit);
	}

	@Override
	public void withdraw(double amount) {
		double total = amount + WITHDRAW_FEE;
		super.withdraw(total);
		System.out.println("Cheking Account: Fee applied $" + WITHDRAW_FEE);
	}
}