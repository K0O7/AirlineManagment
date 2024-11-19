package airline;

import java.util.Objects;

public class PrivatePlane extends Airplane {
	private double price;
	private final static int PRIME = 21;
	
	public PrivatePlane(String model, double totalPrice, double price) {
		super(model, totalPrice);
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
