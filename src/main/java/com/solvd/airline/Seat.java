package main.java.com.solvd.airline;

import java.util.Objects;

public class Seat {
	private double price;
	private SeatClass seatClass;

	public Seat(double price, SeatClass seatClass) throws NegativeValueException {
		super();
		this.setPrice(price);
		this.seatClass = seatClass;
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

	public SeatClass getSeatClass() {
		return seatClass;
	}

	public void setSeatClass(SeatClass seatClass) {
		this.seatClass = seatClass;
	}

	@Override
	public int hashCode() {
		return Objects.hash(price, seatClass);
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
		return Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price) && seatClass == other.seatClass;
	}

	public enum SeatClass {
		ECONOMY("Basic comfort"),
		BUSINESS("High comfort"),
		FIRST_CLASS("Luxury comfort");

		private final String comfortLevel;

		SeatClass(String comfortLevel) {
			this.comfortLevel = comfortLevel;
		}

		public String getComfortLevel() {
			return comfortLevel;
		}
	}
}
