package airline;

public class Laggage {
	private double maxWeight;

	public Laggage(double maxWeight) {
		super();
		this.setMaxWeight(maxWeight);
	}

	public double getMaxWeight() {
		return maxWeight;
	}

	public void setMaxWeight(double maxWeight) {
		if (maxWeight >= 0) {
			this.maxWeight = maxWeight;
		}
	}
}
