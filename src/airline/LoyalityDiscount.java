package airline;

public class LoyalityDiscount extends Discount {
	private int minReservations;
	
	public LoyalityDiscount(int discountPercent, int minReservations) {
		super(discountPercent);
		this.setMinReservations(minReservations);
	}

	public int getMinReservations() {
		return minReservations;
	}

	public void setMinReservations(int minReservations) {
		if (minReservations >= 0) {
			this.minReservations = minReservations;
		}
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
}
