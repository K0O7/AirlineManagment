package airline;

public class Flight {
	private FlightRoute route;

	public Flight(FlightRoute route) {
		super();
		this.route = route;
	}

	public FlightRoute getRoute() {
		return route;
	}

	public void setRoute(FlightRoute route) {
		this.route = route;
	}
}
