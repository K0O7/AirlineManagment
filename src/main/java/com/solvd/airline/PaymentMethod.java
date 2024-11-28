package main.java.com.solvd.airline;

public abstract class PaymentMethod implements ITransactionable {
	protected boolean isActive;

	public PaymentMethod(boolean isActive) {
		super();
		this.setActive(isActive);
	}

	public abstract boolean getActive();

	public abstract void setActive(boolean isActive);
	
	@Override
	public abstract boolean authorizePayment(double amount);

	@Override
	public abstract boolean refundPayment(double amount);

	@Override
	public abstract String getTransactionDetails();
}
