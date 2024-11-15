package airline;

public class CreditCard extends PaymentMethod {
	private String cardNumber;

	public CreditCard(boolean isActive, String cardNumber) {
		super(isActive);
		this.cardNumber = cardNumber;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
}
