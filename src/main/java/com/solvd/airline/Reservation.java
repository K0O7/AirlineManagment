package main.java.com.solvd.airline;

public class Reservation {
	private Flight flight;
	private Customer customer;
    private ReservationStatus status;

	public Reservation(Flight flight, Customer customer) {
		super();
		this.setFlight(flight);
		this.setCustomer(customer);
		this.setStatus(ReservationStatus.BOOKED);
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
	
    public ReservationStatus getStatus() {
        return status;
    }

    public void setStatus(ReservationStatus status) {
        this.status = status;
    }
	
	public enum ReservationStatus {
	    BOOKED(1, "The reservation has been successfully booked."),
	    CANCELLED(2, "The reservation has been cancelled."),
	    COMPLETED(3, "The reservation is completed."),
	    PENDING(4, "The reservation is pending confirmation."),
	    CHECKED_IN(5, "The reservation has been checked in.");

	    private final int code; // Unique code for each status
	    private final String description; // Description of the status

	    // Constructor to initialize the code and description for each status
	    ReservationStatus(int code, String description) {
	        this.code = code;
	        this.description = description;
	    }

	    // Getter methods to access the fields
	    public int getCode() {
	        return code;
	    }

	    public String getDescription() {
	        return description;
	    }

	    // Method to get a status by code (useful for lookups)
	    public static ReservationStatus fromCode(int code) {
	        for (ReservationStatus status : ReservationStatus.values()) {
	            if (status.getCode() == code) {
	                return status;
	            }
	        }
	        throw new IllegalArgumentException("Unknown status code: " + code);
	    }

	    // Method to perform some action based on the status
	    public void performAction() {
	        switch (this) {
	            case BOOKED:
	                System.out.println("Reservation is now confirmed.");
	                break;
	            case CANCELLED:
	                System.out.println("Reservation has been cancelled.");
	                break;
	            case COMPLETED:
	                System.out.println("Reservation has been completed.");
	                break;
	            case PENDING:
	                System.out.println("Reservation is still pending.");
	                break;
	            case CHECKED_IN:
	                System.out.println("Reservation checked-in, ready for flight.");
	                break;
	            default:
	                System.out.println("Unknown status.");
	        }
	    }
	}
}
