package main.java.com.solvd.airline;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;


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
    
    public static String readFile() {
    	File file = new File("C:/tools/java-projects/homework/tekst.txt");
    	String content = null;
    	try {
    		content = FileUtils.readFileToString(file, "UTF-8");
    	} catch(IOException e) {
    		System.out.print("no file to read");
    	}
    	return content;
    }
    
    public static void saveFile(int number) {
        try {
            File outputFile = new File("C:/tools/java-projects/homework/uniqueWordCount.txt");
            FileUtils.writeStringToFile(outputFile, "Number of unique words: " + number, "UTF-8");
            System.out.println("Unique word count saved to file: " + "uniqueWordCount.txt");
        } catch (IOException e) {
            System.err.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }
    
    public static int countUniqueWords(String input) {
        String[] words = StringUtils.split(input);

        Set<String> uniqueWords = new HashSet<>();

        if (words != null) {
            for (String word : words) {
                uniqueWords.add(word.toLowerCase().replaceAll("[^a-zA-Z0-9]", ""));
            }
        }
        return uniqueWords.size();
    }
    
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		//Airplane airplane = new Airplane(null);
		//Person person = new Person(null);
		//PaymentMethod paymentMethod = new PaymentMethod(true);
		//Discount discount = new Discount(0);
		Airport airport = new Airport(null, null);
		Customer customer = new Customer(null, null, new ArrayList<Reservation>());
		Emploee emploee1 = new Emploee(null, null, null);
		Emploee emploee2 = new Emploee(null, null, null);
		List<Emploee> emploees = new ArrayList<Emploee>();
		emploees.add(emploee1);
		emploees.add(emploee2);
		PrivatePlane privatePlane = new PrivatePlane(null, 0, emploees, 0);
		
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
			List<Seat> seats = new ArrayList<Seat>();
			seats.add(seat1);
			seats.add(seat2);
			PassengerPlane passengerPlane = new PassengerPlane(null, 0, emploees, seats);
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
		
		saveFile(countUniqueWords(readFile()));
		
		System.out.print("works");
	}
}
/* 
8
Read text from the file and calculate the numbers of the unique words. Write the result to the file. 
The main requirement is: using StringUtils and FileUtils to implement it with minimum lines of code.

9
Use at least 5 lambda functions from the java.util.function package.
Create 3 custom Lambda functions with generics.
Create 5 complex Enums(with fields, methods, blocks).
*/
