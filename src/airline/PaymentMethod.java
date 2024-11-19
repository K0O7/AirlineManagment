package airline;

public abstract class PaymentMethod {
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
	
}
