package main.java.com.solvd.airline;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.*;
import java.util.stream.Collectors;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import main.java.com.solvd.airline.Reservation.ReservationStatus;


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
    
    public static void reflection() {
        try {
            Class<?> airportClass = Class.forName("main.java.com.solvd.airline.Airport");

            System.out.println("Fields of Airport:");
            Field[] fields = airportClass.getDeclaredFields();
            for (Field field : fields) {
                System.out.println("Field Name: " + field.getName());
                System.out.println("Field Type: " + field.getType().getName());
                System.out.println("Modifiers: " + Modifier.toString(field.getModifiers()));
                System.out.println("---------------");
            }

            System.out.println("Constructors of Airport:");
            Constructor<?>[] constructors = airportClass.getDeclaredConstructors();
            for (Constructor<?> constructor : constructors) {
                System.out.println("Constructor Name: " + constructor.getName());
                System.out.println("Modifiers: " + Modifier.toString(constructor.getModifiers()));
                System.out.println("Parameters: " + Arrays.toString(constructor.getParameterTypes()));
                System.out.println("---------------");
            }

            System.out.println("Methods of Airport:");
            Method[] methods = airportClass.getDeclaredMethods();
            for (Method method : methods) {
                System.out.println("Method Name: " + method.getName());
                System.out.println("Return Type: " + method.getReturnType().getName());
                System.out.println("Modifiers: " + Modifier.toString(method.getModifiers()));
                System.out.println("Parameters: " + Arrays.toString(method.getParameterTypes()));
                System.out.println("---------------");
            }

            Constructor<?> airportConstructor = airportClass.getConstructor(String.class, String.class);
            Object airportInstance = airportConstructor.newInstance("John F. Kennedy", "New York");


            Method getNameMethod = airportClass.getMethod("getName");
            Object name = getNameMethod.invoke(airportInstance);
            System.out.println("Airport Name: " + name);

            Method getLocationMethod = airportClass.getMethod("getLocation");
            Object location = getLocationMethod.invoke(airportInstance);
            System.out.println("Airport Location: " + location);

            Method getUniqueIdMethod = airportClass.getMethod("getUniqueId");
            Object uniqueId = getUniqueIdMethod.invoke(airportInstance);
            System.out.println("Airport Unique ID: " + uniqueId);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
	@SuppressWarnings("unused")
	public static void main(String[] args) throws InterruptedException {
			
		//Airplane airplane = new Airplane(null);
		//Person person = new Person(null);
		//PaymentMethod paymentMethod = new PaymentMethod(true);
		//Discount discount = new Discount(0);
		Airport airport = new Airport("chopin", "poland");
		Customer customer = new Customer(null, null, new ArrayList<Reservation>());
		Emploee emploee1 = new Emploee(null, null, null);
		Emploee emploee2 = new Emploee(null, null, null);
		List<Emploee> emploees = new ArrayList<Emploee>();
		emploees.add(emploee1);
		emploees.add(emploee2);
		PrivatePlane privatePlane = new PrivatePlane(null, 0, emploees, 0);
		
		CreditCard creditCard = null;
		try {
			creditCard = new CreditCard(false, "1234567891234567");
		} catch (InvalidCreditCardNumberException e) {
			System.out.println(e.getMessage());
		} finally {
			System.out.println("Credit card validation process completed.");
		}
		
		FlightRoute flightRoute = null;
		Reservation reservation = null;
		try {
			flightRoute = new FlightRoute(0, airport, airport);
			Flight flight = new Flight(flightRoute, null, new Date(), new Date());
			reservation = new Reservation(flight, customer);
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
		
		PassengerPlane passengerPlane;
		Seat seat;
		try {
			Seat seat1 = new Seat(0, Seat.SeatClass.ECONOMY);
			Seat seat2 = new Seat(0, Seat.SeatClass.BUSINESS);
			List<Seat> seats = new ArrayList<Seat>();
			seats.add(seat1);
			seats.add(seat2);
			passengerPlane = new PassengerPlane(null, 0, emploees, seats);
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
		
        Predicate<Flight> isDomestic = flight -> flight.getRoute().getEndAirport().getLocation().equals(flight.getRoute().getStartAirport().getLocation());

        Function<Double, Double> applyDiscount = price -> price * 0.9; // 10% discount

        Supplier<Airport> defaultAirport = () -> new Airport("Default Airport", "Location");

        Consumer<Flight> printFlightDetails = flight -> System.out.println("Flight ID: " + flight.getUniqueId());

        BiFunction<Double, Integer, Double> calculateTotal = (pricePerSeat, numSeats) -> pricePerSeat * numSeats;
		
        Airport airport2 = defaultAirport.get();
        System.out.println("Default Airport: " + airport.getName());

        Flight flight2;
		try {
			Seat seat1 = new Seat(0, Seat.SeatClass.ECONOMY);
			Seat seat2 = new Seat(0, Seat.SeatClass.BUSINESS);
			List<Seat> seats = new ArrayList<Seat>();
			seats.add(seat1);
			seats.add(seat2);
			PassengerPlane passengerPlane2 = new PassengerPlane(null, 0, emploees, seats);
			flight2 = new Flight(new FlightRoute(0, airport, airport), passengerPlane2, new Date(), new Date());
			flights.add(flight2);
			printFlightDetails.accept(flight2);
			System.out.println("Is the flight domestic? " + isDomestic.test(flight2));
		} catch (NegativeValueException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println("Discounted Price: " + applyDiscount.apply(100.0));
        System.out.println("Total Price: " + calculateTotal.apply(50.0, 2));
        
        Comparator<Flight> sortByDeparture = (f1, f2) -> f1.getDepartureTime().compareTo(f2.getDepartureTime());

        BiFunction<Integer, Integer, Integer> addNumbers = (a, b) -> a + b;

        Predicate<List<?>> isListEmpty = List::isEmpty;

        System.out.println("Is flight list empty? " + isListEmpty.test(flights));
        
        
        List<Flight> upcomingFlights = flights.stream()
        		.filter(flight -> flight.getDepartureTime().after(new Date()))
        	    .sorted(Comparator.comparing(Flight::getDepartureTime))
        	    .collect(Collectors.toList());

        upcomingFlights.forEach(flight -> System.out.println(flight.getUniqueId()));
        	
        Set<Airport> airports = new HashSet<>();
        airports.add(airport2);
        airports.add(airport);


	    List<String> airportNames = airports.stream()
	    		.filter(airport3 -> airport3.getLocation().equals("Poland"))
	    		.map(Airport::getName)
	    		.collect(Collectors.toList());
	
	    airportNames.forEach(System.out::println);
	     
	    List<Reservation> reservations = new ArrayList<>();
	    reservations.add(reservation);

	    List<String> flightCodes = reservations.stream()
	    		.filter(reservation2 -> reservation2.getStatus() == ReservationStatus.BOOKED)
	    		.map(reservation2 -> reservation2.getFlight().getUniqueId()) 
	    		.collect(Collectors.toList()); 

	    flightCodes.forEach(System.out::println);
	    
	    Set<Emploee> employees = new HashSet<>();
	    employees.add(emploee2);
	    employees.add(emploee1);

	    employees.stream()
	     	.sorted(Comparator.comparing(Emploee::getName))
	     	.forEach(employee -> System.out.println(employee.getName()));
	    
	    List<Reservation> customerReservations = customer.getReservations();

	    int totalReservations = customerReservations.stream()
	        .filter(reservation2 -> reservation2.getCustomer().equals(customer))
	        .mapToInt(reservation2 -> 1)
	        .sum();

	    System.out.println("Total reservations: " + totalReservations);
	    
	    List<CreditCard> creditCards = new ArrayList<>();
	    creditCards.add(creditCard);

	    long validCreditCardCount = creditCards.stream()
	    		.filter(creditCard2 -> creditCard2.getActive())
	    		.count();

	    System.out.println("Valid Credit Cards: " + validCreditCardCount);
	    
	    List<FlightRoute> flightRoutes = new ArrayList<>();
	    flightRoutes.add(flightRoute);

	    Map<String, Long> airportFlightCounts = flightRoutes.stream()
	    		.filter(route -> route.getStartAirport().getLocation().equals("poland") || 
	                     route.getEndAirport().getLocation().equals("poland"))
	    		.map(route -> route.getStartAirport().getLocation())
	    		.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

	    airportFlightCounts.forEach((location, count) -> System.out.println(location + ": " + count));
	    
	    reflection();
	    
	    ConnectionPool connectionPool = new ConnectionPool();

        ExecutorService executor = Executors.newFixedThreadPool(7);

        for (int i = 0; i < 7; i++) {
            executor.submit(new ConnectionTask(connectionPool));
        }

        executor.shutdown();
        if (!executor.awaitTermination(60, TimeUnit.SECONDS)) {
            executor.shutdownNow();
        }

        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            try {
                Connection connection = connectionPool.getConnection();
                System.out.println("Async Task got " + connection);
                Thread.sleep(1000);
                connectionPool.releaseConnection(connection);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        future.join();
        System.out.println("Asynchronous task completed.");
	}
}


class Connection {
    private static int idCounter = 1;
    private final int id;

    public Connection() {
        this.id = idCounter++;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Connection-" + id;
    }
}

class ConnectionPool {
    private final BlockingQueue<Connection> pool;
    private static final int MAX_SIZE = 5;
    private static AtomicBoolean initialized = new AtomicBoolean(false);

    public ConnectionPool() {
        this.pool = new LinkedBlockingQueue<>(MAX_SIZE);
    }

    public Connection getConnection() throws InterruptedException {
        if (!initialized.getAndSet(true)) {
            initializePool();
        }
        return pool.take();
    }

    public void releaseConnection(Connection connection) {
        try {
            pool.put(connection);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private void initializePool() {
        for (int i = 0; i < MAX_SIZE; i++) {
            pool.offer(new Connection());
        }
        System.out.println("Connection pool initialized with " + MAX_SIZE + " connections.");
    }
}

class ConnectionTask implements Runnable {
    private final ConnectionPool connectionPool;

    public ConnectionTask(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }

    @Override
    public void run() {
        try {
            Connection connection = connectionPool.getConnection();
            System.out.println(Thread.currentThread().getName() + " got " + connection);
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName() + " released " + connection);
            connectionPool.releaseConnection(connection);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
/* 
switch all print with logger
*/
