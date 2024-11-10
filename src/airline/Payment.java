package airline;

public class Payment {
	private double amount;

	public Payment(double amount) {
		super();
		this.setAmount(amount);
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		if (amount >= 0) {
			this.amount = amount;
		}
	}
}
