package main.java.com.solvd.airline;

import java.util.Objects;

public abstract class Airplane {
	protected String model;
	protected double totalPrice;

	public Airplane(String model, double totalPrice) {
		super();
		this.setModel(model);
		this.setTotalPirce(totalPrice);
	}

	public abstract double getTotalPirce();

	public abstract void setTotalPirce(double totalPirce);

	public abstract String getModel();

	public abstract void setModel(String model);

	@Override
	public String toString() {
		return "Airplane [model=" + model + ", totalPirce=" + totalPrice + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(model, totalPrice);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Airplane other = (Airplane) obj;
		return Objects.equals(model, other.model)
				&& Double.doubleToLongBits(totalPrice) == Double.doubleToLongBits(other.totalPrice);
	}
	
}
