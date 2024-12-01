package main.java.com.solvd.airline;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Customer extends Person {
	private List<Reservation> reservations;
	private static final int PRIME = 31;

	public Customer(String name, String surname, List<Reservation> reservations) {
		super(name, surname);
		this.setReservations(reservations);
	}
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String getSurname() {
		return surname;
	}

	@Override
	public void setSurname(String surname) {
		this.surname = surname;
	}

	public List<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}
	
    public void addReservation(Reservation reservation) throws DuplicateReservationException {
        if (this.reservations.contains(reservation)) {
            throw new DuplicateReservationException(
                "Reservation already exists for customer: " + reservation.getCustomer().getName());
        }
        this.reservations.add(reservation);
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(reservations);
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
		Customer other = (Customer) obj;
		return Objects.equals(reservations, other.reservations);
	}
}
