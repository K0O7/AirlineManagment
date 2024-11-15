package airline;

public abstract class Discount {
	protected int discountPercent;

	public Discount(int discountPercent) {
		super();
		this.setDiscountPercent(discountPercent);
	}

	public int getDiscountPercent() {
		return discountPercent;
	}

	public void setDiscountPercent(int discountPercent) {
		if (discountPercent >= 0 && discountPercent <= 100) {
			this.discountPercent = discountPercent;
		}
	}
	
	public boolean checkEligibility(Reservation reservation) {
		return false;
	}
}
