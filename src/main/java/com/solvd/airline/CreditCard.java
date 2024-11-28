package main.java.com.solvd.airline;

public final class CreditCard extends PaymentMethod {
	private String cardNumber;

	public CreditCard(boolean isActive, String cardNumber) throws InvalidCreditCardNumberException {
		super(isActive);
		this.setCardNumber(cardNumber);
	}
	
	@Override
	public boolean getActive() {
		return isActive;
	}
	
	@Override
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) throws InvalidCreditCardNumberException {
        if (cardNumber == null || !cardNumber.matches("\\d{16}")) {
            throw new InvalidCreditCardNumberException("Invalid credit card number. It must be exactly 16 digits.");
        }
		this.cardNumber = cardNumber;
	}

	@Override
	public boolean authorizePayment(double amount) {
		System.out.println("Credit Card payment of $" + amount + " authorized.");
	    return true;
	}

	@Override
	public boolean refundPayment(double amount) {
        System.out.println("Credit Card refund of $" + amount + " processed.");
        return true;
	}

	@Override
	public String getTransactionDetails() {
		return "Credit Card ending in " + cardNumber.substring(cardNumber.length() - 4);
	}
}