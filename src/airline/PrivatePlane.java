package airline;

public class PrivatePlane {
	private double price;

	public PrivatePlane(double price) {
		super();
		this.setPrice(price);
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		if (price >= 0) {
			this.price = price;
		}
	}
}
