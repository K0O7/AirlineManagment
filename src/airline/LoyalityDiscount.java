package airline;

public class LoyalityDiscount {
	private int minReservations;

	public LoyalityDiscount(int minReservations) {
		super();
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
}
