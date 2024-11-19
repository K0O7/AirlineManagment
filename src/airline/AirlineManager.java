package airline;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AirlineManager {
	
    private static List<Airport> airports;
    private static List<Flight> flights;

    // Static block
    static {
        airports = new ArrayList<>();
        flights = new ArrayList<>();
        System.out.println("AirlineManager initialized with default data.");
    }
	
    public static Flight findFlightByCode(String flightCode) {
        for (Flight flight : flights) {
            if (flight.getUniqueId().equals(flightCode)) {
                return flight;
            }
        }
        return null; // Flight not found
    }
    
	public static void main(String[] args) {
		//Airplane airlplane = new Airplane(null);
		//Person person = new Person(null);
		//PaymentMethod paymentMethod = new PaymentMethod(true);
		//Discount discount = new Discount(0);
		Airport airport = new Airport(null, null);
		CreditCard creditCard = new CreditCard(false, null);
		Customer customer = new Customer(null, null, new ArrayList<Reservation>());
		Emploee emploee = new Emploee(null, null, null);
		FlightRoute flightRoute = new FlightRoute(0, airport, airport);
		Flight flight = new Flight(flightRoute, null, new Date(), new Date());
		Laggage laggage = new Laggage(0);
		LoyalityDiscount loyalityDiscount = new LoyalityDiscount(0, 0);
		Seat[] seats = {new Seat(0)};
		PassengerPlane passengerPlane = new PassengerPlane(null, 0, seats);
		Payment payment = new Payment(0);
		PayPal payPal = new PayPal(false, null);
		PrivatePlane privatePlane = new PrivatePlane(null, 0, 0);
		Reservation reservation = new Reservation(flight, customer);
		SeasonalDiscount seasonalDiscount = new SeasonalDiscount(0, null, null);
		System.out.print("works");
	}
}


/*
Use polymorphism with the abstract class and interface from the hierarchy.
*/