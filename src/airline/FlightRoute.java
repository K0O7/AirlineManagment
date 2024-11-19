package airline;

public class FlightRoute {
	private double distance;
	private Airport startAirport;
	private Airport endAirport;
	

	public FlightRoute(double distance, Airport startAirport, Airport endAirport) {
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

	public void setDistance(double distance) {
		if (distance >= 0) {
			this.distance = distance;
		}
	}

}
