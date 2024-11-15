package airline;

public class PayPal extends PaymentMethod {
	private String payPalAcc;
	
	public PayPal(boolean isActive, String payPalAcc) {
		super(isActive);
		this.payPalAcc = payPalAcc;
	}

	public String getPayPalAcc() {
		return payPalAcc;
	}

	public void setPayPalAcc(String payPalAcc) {
		this.payPalAcc = payPalAcc;
	}
}
