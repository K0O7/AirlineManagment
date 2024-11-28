package main.java.com.solvd.airline;

import java.util.Arrays;

public class PassengerPlane extends Airplane {
	private Seat[] seats;
	private final static int PRIME = 31;
	
	public PassengerPlane(String model, double totalPrice, Seat[] seats) {
		super(model, totalPrice);
		this.setSeats(seats);
	}
	
	@Override
	public double getTotalPirce() {
		return this.totalPrice;
	}

	@Override
	public void setTotalPirce(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	@Override
	public String getModel() {
		return this.model;
	}

	@Override
	public void setModel(String model) {
		this.model = model;
		
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
