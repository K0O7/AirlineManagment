package airline;

public class Discount {
	private int discountPercent;

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
}
