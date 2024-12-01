package main.java.com.solvd.airline;

import java.util.List;
import java.util.Objects;

public class PassengerPlane extends Airplane {
	private List<Seat> seats;
	private final static int PRIME = 31;
	
	public PassengerPlane(String model, double totalPrice, List<Emploee> emploees, List<Seat> seats) {
		super(model, totalPrice, emploees);
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
	
	@Override
	public List<Emploee> getEmploees() {
		return this.emploees;
	}

	@Override
	public void setEmploees(List<Emploee> emploees) {
		this.emploees = emploees;
	}
	
	public List<Seat> getSeats() {
		return seats;
	}

	public void setSeats(List<Seat> seats) {
		this.seats = seats;
	}

	@Override
	public int hashCode() {
		int result = super.hashCode();
		result = PRIME * result + Objects.hash(seats);
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
		return Objects.equals(seats, other.seats);
	}

	@Override
	public String toString() {
		return "PassengerPlane [seats=" + seats + "]";
	}	
}
