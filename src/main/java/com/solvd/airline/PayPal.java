package main.java.com.solvd.airline;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class PayPal extends PaymentMethod {
    private static final Logger logger = LogManager.getLogger(PayPal.class);
	private String payPalAcc;
	
	public PayPal(boolean isActive, String payPalAcc) throws InvalidEmailException {
		super(isActive);
		this.setPayPalAcc(payPalAcc);
	}
	
	@Override
	public boolean getActive() {
		return isActive;
	}
	
	@Override
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public String getPayPalAcc() {
		return payPalAcc;
	}

	public void setPayPalAcc(String payPalAcc) throws InvalidEmailException {
		if (payPalAcc == null || !payPalAcc.matches("^[\\w._%+-]+@[\\w.-]+\\.[a-zA-Z]{2,}$")) {
            throw new InvalidEmailException("Invalid email address format.");
        }
		this.payPalAcc = payPalAcc;
	}

	@Override
	public boolean authorizePayment(double amount) {
		logger.info("PayPal payment of $" + amount + " authorized for " + payPalAcc);
        return true;
	}

	@Override
	public boolean refundPayment(double amount) {
		logger.info("PayPal refund of $" + amount + " processed for " + payPalAcc);
        return true;
	}

	@Override
	public String getTransactionDetails() {
        return "PayPal account: " + payPalAcc;
	}
}
