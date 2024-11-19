package airline;

public abstract class PaymentMethod implements ITransactionable {
	protected boolean isActive;

	public PaymentMethod(boolean isActive) {
		super();
		this.setActive(isActive);
	}

	public boolean getActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	
	@Override
	public abstract boolean authorizePayment(double amount);

	@Override
	public abstract boolean refundPayment(double amount);

	@Override
	public abstract String getTransactionDetails();
}
