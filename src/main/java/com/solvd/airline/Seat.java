package main.java.com.solvd.airline;

import java.util.Objects;

public class Seat {
	private double price;

	public Seat(double price) throws NegativeValueException {
		super();
		this.setPrice(price);
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) throws NegativeValueException {
		if (price < 0) {
			throw new NegativeValueException("Price cannot be negative.");
		}
		this.price = price;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(price);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Seat other = (Seat) obj;
		return Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price);
	}
}
