package main.java.com.solvd.airline;

public class FlightRoute {
	private double distance;
	private Airport startAirport;
	private Airport endAirport;
	

	public FlightRoute(double distance, Airport startAirport, Airport endAirport) throws NegativeValueException {
		super();
		this.setDistance(distance);
		this.setStartAirport(startAirport);
		this.setEndAirport(endAirport);
	}

	public Airport getStartAirport() {
		return startAirport;
	}

	public void setStartAirport(Airport startAirport) {
		this.startAirport = startAirport;
	}

	public Airport getEndAirport() {
		return endAirport;
	}

	public void setEndAirport(Airport endAirport) {
		this.endAirport = endAirport;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) throws NegativeValueException {
		if (distance < 0) {
			throw new NegativeValueException("Distance cannot be negative.");
		}
		this.distance = distance;
	}

}
