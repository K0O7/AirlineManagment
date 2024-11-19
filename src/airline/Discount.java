package airline;

public abstract class Discount implements IAppliable {
	protected double discountPercent;

	public Discount(double discountPercent) {
		super();
		this.setDiscountPercent(discountPercent);
	}

	public double getDiscountPercent() {
		return discountPercent;
	}

	public void setDiscountPercent(double discountPercent) {
		if (discountPercent >= 0 && discountPercent <= 100) {
			this.discountPercent = discountPercent;
		}
	}
	
	public abstract boolean checkEligibility(Reservation reservation);
	
	 @Override
	 public abstract double apply(double amount);
}
