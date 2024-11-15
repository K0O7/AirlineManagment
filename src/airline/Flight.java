package airline;
import java.util.Date;

public class Flight {
	private FlightRoute route;
	private Airplane airplane;
	private Date departureTime;
	private Date arrivalTime;

	public Flight(FlightRoute route, Airplane airplane, Date departureTime, Date arrivalTime) {
		super();
		this.airplane = airplane;
		this.route = route;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
	}

	public Airplane getAirplane() {
		return airplane;
	}

	public void setAirplane(Airplane airplane) {
		this.airplane = airplane;
	}

	public Date getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(Date departureTime) {
		this.departureTime = departureTime;
	}

	public Date getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(Date arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public FlightRoute getRoute() {
		return route;
	}

	public void setRoute(FlightRoute route) {
		this.route = route;
	}
}
