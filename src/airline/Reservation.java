package airline;

public class Reservation {
	private Flight flight;

	public Reservation(Flight flight) {
		super();
		this.flight = flight;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}
}
