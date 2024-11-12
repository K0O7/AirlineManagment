package airline;

public class Seat {
	private double price;

	public Seat(double price) {
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
