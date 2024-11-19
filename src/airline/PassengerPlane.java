package airline;

import java.util.Arrays;

public class PassengerPlane extends Airplane {
	private Seat[] seats;
	private final static int PRIME = 31;
	
	public PassengerPlane(String model, double totalPrice, Seat[] seats) {
		super(model, totalPrice);
		this.setSeats(seats);
	}
	
	public Seat[] getSeats() {
		return seats;
	}

	public void setSeats(Seat[] seats) {
		this.seats = seats;
	}

	@Override
	public int hashCode() {
		int result = super.hashCode();
		result = PRIME * result + Arrays.hashCode(seats);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		PassengerPlane other = (PassengerPlane) obj;
		return Arrays.equals(seats, other.seats);
	}

	@Override
	public String toString() {
		return "PassengerPlane [seats=" + Arrays.toString(seats) + "]";
	}
	
}
