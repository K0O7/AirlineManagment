package main.java.com.solvd.airline;
import java.util.Date;

public class Flight implements IIdentifiable, IReservable, ITrackable {
	private FlightRoute route;
	private Airplane airplane;
	private Date departureTime;
	private Date arrivalTime;
	private String status;

	public Flight(FlightRoute route, Airplane airplane, Date departureTime, Date arrivalTime) {
		super();
		this.setAirplane(airplane);
		this.setRoute(route);
		this.setDepartureTime(departureTime);
		this.setArrivalTime(arrivalTime);
		this.setStatus("Scheduled");
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
	
	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String getStatus() {
        return status;
	}

	@Override
	public void updateStatus(String status) {
        this.status = status;
        System.out.println("Flight status updated to: " + this.getStatus());
	}

	@Override
	public boolean reserve() {
        System.out.println("Flight reserved: " + this.getUniqueId());
        return true;
	}

	@Override
	public boolean cancelReservation() {
        System.out.println("Flight reservation canceled: " + this.getUniqueId());
        return true;
	}

	@Override
	public String getUniqueId() {
        return this.getRoute().getEndAirport().getUniqueId() + "-" + this.getDepartureTime().toString() + "-" + 
        		this.getAirplane() + "-" + this.getRoute().getEndAirport().getUniqueId() + "-" + this.getArrivalTime().toString();
	}
	
	
}
