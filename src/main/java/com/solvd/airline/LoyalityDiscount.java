package main.java.com.solvd.airline;

public class LoyalityDiscount extends Discount {
	private int minReservations;
	
	public LoyalityDiscount(int discountPercent, int minReservations) throws NegativeValueException, InvalidPercentageException {
		super(discountPercent);
		this.setMinReservations(minReservations);
	}

	public int getMinReservations() {
		return minReservations;
	}

	public void setMinReservations(int minReservations) throws NegativeValueException {
		if (minReservations < 0) {
			throw new NegativeValueException("Number of reservations cannot be negative.");
		}
		this.minReservations = minReservations;
	}

	@Override
	public final boolean checkEligibility(Reservation reservation) {
		if (this.minReservations < reservation.getCustomer().getReservations().size()) {
			return true;
		}
		return false;
	}

	@Override
	public double apply(double amount) {
		return amount - (amount * this.discountPercent / 100);
	}

	@Override
	public double getDiscountPercent() {
		return this.discountPercent;
	}

	@Override
	public void setDiscountPercent(double discountPercent) throws InvalidPercentageException {
		if (discountPercent < 0 || discountPercent > 100) {
			throw new InvalidPercentageException("Percentage must be between 0 and 100.");
		}
		this.discountPercent = discountPercent;
	}
}
