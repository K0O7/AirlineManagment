package airline;

public class Customer {
	private Reservation[] reservations;

	public Customer() {
		super();
		this.reservations = null;
	}

	public Reservation[] getReservations() {
		return reservations;
	}

	public void setReservations(Reservation[] reservations) {
		this.reservations = reservations;
	}
}
