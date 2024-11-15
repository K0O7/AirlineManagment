package airline;
import java.util.ArrayList;

public class Customer extends Person {
	private ArrayList<Reservation> reservations;

	public Customer(String name, String surname, ArrayList<Reservation> reservations) {
		super(name, surname);
		this.reservations = reservations;
	}

	public ArrayList<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(ArrayList<Reservation> reservations) {
		this.reservations = reservations;
	}
	
	public void addReservation(Reservation reservation) {
		this.reservations.add(reservation);
	}
}
