package main.java.com.solvd.airline;

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
    
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		//Airplane airplane = new Airplane(null);
		//Person person = new Person(null);
		//PaymentMethod paymentMethod = new PaymentMethod(true);
		//Discount discount = new Discount(0);
		Airport airport = new Airport(null, null);
		Customer customer = new Customer(null, null, new ArrayList<Reservation>());
		Emploee emploee = new Emploee(null, null, null);
		PrivatePlane privatePlane = new PrivatePlane(null, 0, 0);
		
		try {
			CreditCard creditCard = new CreditCard(false, "1234567891234567");
		} catch (InvalidCreditCardNumberException e) {
			System.out.println(e.getMessage());
		} finally {
			System.out.println("Credit card validation process completed.");
		}
		
		try {
			FlightRoute flightRoute = new FlightRoute(0, airport, airport);
			Flight flight = new Flight(flightRoute, null, new Date(), new Date());
			Reservation reservation = new Reservation(flight, customer);
		} catch (NegativeValueException  e) {
			System.out.println(e.getMessage());
		} finally {
			System.out.println("Designation of new flight route complete.");
		}
		
        try (AutoCloseable laggageResource = () -> System.out.println("Prepering for laggage registration...")) {
        	Laggage laggage = new Laggage(10);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Laggage registration process completed.");
        }
		
		
		try {
			LoyalityDiscount loyalityDiscount = new LoyalityDiscount(0, 0);
		} catch (NegativeValueException | InvalidPercentageException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {
			System.out.println("Creating of new loyality discount completed.");
		}
		
		
		Seat seat;
		try {
			Seat seat1 = new Seat(0);
			Seat seat2 = new Seat(0);
			Seat[] seats = {seat1, seat2};
			PassengerPlane passengerPlane = new PassengerPlane(null, 0, seats);
		} catch (NegativeValueException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {
			System.out.println("Creating of new passenger plane completed.");
		}
		
		try {
			Payment payment = new Payment(0);
		} catch (NegativeValueException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		try {
			PayPal payPal = new PayPal(false, "test@gmail.com");
		} catch (InvalidEmailException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {
			System.out.println("Paypal validation process completed.");
		}
		
		try {
			SeasonalDiscount seasonalDiscount = new SeasonalDiscount(0, null, null);
		} catch (InvalidPercentageException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {
			System.out.println("Creating of new seasonal discount completed.");
		}
		
		System.out.print("works");
	}
}