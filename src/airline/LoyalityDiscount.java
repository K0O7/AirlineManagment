package airline;

public class LoyalityDiscount {
	private int minReservations;

	public LoyalityDiscount(int minReservations) {
		super();
		this.minReservations = minReservations;
	}

	public int getMinReservations() {
		return minReservations;
	}

	public void setMinReservations(int minReservations) {
		this.minReservations = minReservations;
	}
}
