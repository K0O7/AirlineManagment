package main.java.com.solvd.airline;

public abstract class Discount implements IAppliable {
	protected double discountPercent;

	public Discount(double discountPercent) throws InvalidPercentageException {
		super();
		this.setDiscountPercent(discountPercent);
	}

	public abstract double getDiscountPercent();

	public abstract void setDiscountPercent(double discountPercent) throws InvalidPercentageException;
	
	public abstract boolean checkEligibility(Reservation reservation);
	
	 @Override
	 public abstract double apply(double amount);
}