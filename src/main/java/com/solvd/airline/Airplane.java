package main.java.com.solvd.airline;

import java.util.List;
import java.util.Objects;

public abstract class Airplane {
	protected Model model;
	protected double totalPrice;
	protected List<Emploee> emploees;

	public Airplane(Model model, double totalPrice, List<Emploee> emploees) {
		super();
		this.setModel(model);
		this.setTotalPirce(totalPrice);
	}

	public abstract double getTotalPirce();

	public abstract void setTotalPirce(double totalPirce);

	public abstract Model getModel();

	public abstract void setModel(Model model);
	
	public abstract List<Emploee> getEmploees();
	
	public abstract void setEmploees(List<Emploee> emploees);

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
	
	public enum Model {
        BOEING_747("Boeing 747", 416, "Commercial"),
        AIRBUS_A380("Airbus A380", 555, "Commercial"),
        GULFSTREAM_G650("Gulfstream G650", 18, "Private"),
        CESSNA_172("Cessna 172", 4, "General Aviation");

        private final String name;
        private final int capacity;
        private final String category;

        Model(String name, int capacity, String category) {
            this.name = name;
            this.capacity = capacity;
            this.category = category;
        }

        public String getName() {
            return name;
        }

        public int getCapacity() {
            return capacity;
        }

        public String getCategory() {
            return category;
        }

        @Override
        public String toString() {
            return name + " (Capacity: " + capacity + ", Category: " + category + ")";
        }
    }
	
}
