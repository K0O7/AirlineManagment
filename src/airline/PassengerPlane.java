package airline;

public class PassengerPlane {
	private Seat[] seats;

	public PassengerPlane(Seat[] seats) {
		super();
		this.seats = seats;
	}

	public Seat[] getSeats() {
		return seats;
	}

	public void setSeats(Seat[] seats) {
		this.seats = seats;
	}
}
