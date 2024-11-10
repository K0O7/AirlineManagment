package airline;

public class PaymentMethod {
	private boolean isActive;

	public PaymentMethod(boolean isActive) {
		super();
		this.isActive = isActive;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	
}
