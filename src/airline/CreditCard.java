package airline;

public final class CreditCard extends PaymentMethod {
	private String cardNumber;

	public CreditCard(boolean isActive, String cardNumber) {
		super(isActive);
		this.setCardNumber(cardNumber);
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
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
