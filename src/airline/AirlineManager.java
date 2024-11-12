package airline;

public class AirlineManager {
	public static void main(String[] args) {
		Airplane airlplane = new Airplane(null);
		Airport airport = new Airport(null);
		CreditCard creditCard = new CreditCard(null);
		Customer customer = new Customer();
		Discount discount = new Discount(0);
		Emploee emploee = new Emploee(null);
		FlightRoute flightRoute = new FlightRoute(0);
		Flight flight = new Flight(flightRoute);
		Laggage laggage = new Laggage(0);
		LoyalityDiscount loyalityDiscount = new LoyalityDiscount(0);
		Seat[] seats = {new Seat(0)};
		PassengerPlane passengerPlane = new PassengerPlane(seats);
		Payment payment = new Payment(0);
		PaymentMethod paymentMethod = new PaymentMethod(true);
		PayPal payPal = new PayPal(null);
		Person person = new Person(null);
		PrivatePlane privatePlane = new PrivatePlane(0);
		Reservation reservation = new Reservation(flight);
		SeasonalDiscount seasonalDiscount = new SeasonalDiscount(null, null);
		System.out.print("works");
	}
}
