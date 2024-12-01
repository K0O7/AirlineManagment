package main.java.com.solvd.airline;

import java.util.List;
import java.util.Objects;

public class PrivatePlane extends Airplane {
	private double price;
	private final static int PRIME = 21;
	
	public PrivatePlane(String model, double totalPrice, List<Emploee> emploees, double price) {
		super(model, totalPrice, emploees);
		this.setPrice(price);
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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		if (price >= 0) {
			this.price = price;
		}
	}

	@Override
	public int hashCode() {
		int result = super.hashCode();
		result = PRIME * result + Objects.hash(price);
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
		PrivatePlane other = (PrivatePlane) obj;
		return Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price);
	}

	@Override
	public String toString() {
		return "PrivatePlane [price=" + price + "]";
	}
}
