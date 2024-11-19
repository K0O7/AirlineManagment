package airline;

public final class PayPal extends PaymentMethod {
	private String payPalAcc;
	
	public PayPal(boolean isActive, String payPalAcc) {
		super(isActive);
		this.setPayPalAcc(payPalAcc);
	}

	public String getPayPalAcc() {
		return payPalAcc;
	}

	public void setPayPalAcc(String payPalAcc) {
		this.payPalAcc = payPalAcc;
	}

	@Override
	public boolean authorizePayment(double amount) {
        System.out.println("PayPal payment of $" + amount + " authorized for " + payPalAcc);
        return true;
	}

	@Override
	public boolean refundPayment(double amount) {
        System.out.println("PayPal refund of $" + amount + " processed for " + payPalAcc);
        return true;
	}

	@Override
	public String getTransactionDetails() {
        return "PayPal account: " + payPalAcc;
	}
}
