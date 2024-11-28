package main.java.com.solvd.airline;

public class Payment {
	private double amount;

	public Payment(double amount) throws NegativeValueException {
		super();
		this.setAmount(amount);
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) throws NegativeValueException {
		if (amount < 0) {
			throw new NegativeValueException("Amount to pay cannot be negative.");
		}
		this.amount = amount;
	}
}
