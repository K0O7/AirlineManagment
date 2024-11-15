package airline;

import java.util.Date;

public class AirlineManager {
	public static void main(String[] args) {
		//Airplane airlplane = new Airplane(null);
		//Person person = new Person(null);
		//PaymentMethod paymentMethod = new PaymentMethod(true);
		//Discount discount = new Discount(0);
		Airport airport = new Airport(null);
		CreditCard creditCard = new CreditCard(false, null);
		Customer customer = new Customer(null, null, null);
		Emploee emploee = new Emploee(null, null, null);
		FlightRoute flightRoute = new FlightRoute(0);
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
Add 5 interfaces to the existing hierarchy.
Use polymorphism with the abstract class and interface from the hierarchy.
Create final class, method, variable. 
Create a static block, method, variable. 
*/