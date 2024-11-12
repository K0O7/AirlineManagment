package airline;

public class FlightRoute {
	private double distance;

	public FlightRoute(double distance) {
		super();
		this.setDistance(distance);
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
