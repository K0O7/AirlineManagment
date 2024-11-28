package main.java.com.solvd.airline;

public class Reservation {
	private Flight flight;
	private Customer customer;

	public Reservation(Flight flight, Customer customer) {
		super();
		this.setFlight(flight);
		this.setCustomer(customer);
		this.updateCustomerReservations();
	}
	
	private void updateCustomerReservations() {
        try {
            this.customer.addReservation(this);
        } catch (DuplicateReservationException e) {
            System.out.println(e.getMessage());
        }
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
}
