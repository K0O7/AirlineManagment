package main.java.com.solvd.airline;

public class Laggage {
	private double maxWeight;

	public Laggage(double maxWeight) throws NegativeValueException {
		super();
		this.setMaxWeight(maxWeight);
	}

	public double getMaxWeight() {
		return maxWeight;
	}

	public void setMaxWeight(double maxWeight) throws NegativeValueException {
		if (maxWeight < 0) {
			throw new NegativeValueException("Weight cannot be negative.");
		}
		this.maxWeight = maxWeight;
	}
}
