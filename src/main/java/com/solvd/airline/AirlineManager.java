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

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class AirlineManager {
	
    private static final Logger logger = LogManager.getLogger(AirlineManager.class);
	
    private static List<Airport> airports;
    private static List<Flight> flights;

    // Static block
    static {
        airports = new ArrayList<>();
        flights = new ArrayList<>();
        logger.info("AirlineManager initialized with default data.");
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
    		logger.info("no file to read");
    	}
    	return content;
    }
    
    public static void saveFile(int number) {
        try {
            File outputFile = new File("C:/tools/java-projects/homework/uniqueWordCount.txt");
            FileUtils.writeStringToFile(outputFile, "Number of unique words: " + number, "UTF-8");
            logger.info("Unique word count saved to file: " + "uniqueWordCount.txt");
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

            logger.info("Fields of Airport:");
            Field[] fields = airportClass.getDeclaredFields();
            for (Field field : fields) {
            	logger.info("Field Name: " + field.getName());
            	logger.info("Field Type: " + field.getType().getName());
            	logger.info("Modifiers: " + Modifier.toString(field.getModifiers()));
            	logger.info("---------------");
            }

            logger.info("Constructors of Airport:");
            Constructor<?>[] constructors = airportClass.getDeclaredConstructors();
            for (Constructor<?> constructor : constructors) {
            	logger.info("Constructor Name: " + constructor.getName());
            	logger.info("Modifiers: " + Modifier.toString(constructor.getModifiers()));
            	logger.info("Parameters: " + Arrays.toString(constructor.getParameterTypes()));
            	logger.info("---------------");
            }

            logger.info("Methods of Airport:");
            Method[] methods = airportClass.getDeclaredMethods();
            for (Method method : methods) {
            	logger.info("Method Name: " + method.getName());
            	logger.info("Return Type: " + method.getReturnType().getName());
            	logger.info("Modifiers: " + Modifier.toString(method.getModifiers()));
            	logger.info("Parameters: " + Arrays.toString(method.getParameterTypes()));
            	logger.info("---------------");
            }

            Constructor<?> airportConstructor = airportClass.getConstructor(String.class, String.class);
            Object airportInstance = airportConstructor.newInstance("John F. Kennedy", "New York");


            Method getNameMethod = airportClass.getMethod("getName");
            Object name = getNameMethod.invoke(airportInstance);
            logger.info("Airport Name: " + name);

            Method getLocationMethod = airportClass.getMethod("getLocation");
            Object location = getLocationMethod.invoke(airportInstance);
            logger.info("Airport Location: " + location);

            Method getUniqueIdMethod = airportClass.getMethod("getUniqueId");
            Object uniqueId = getUniqueIdMethod.invoke(airportInstance);
            logger.info("Airport Unique ID: " + uniqueId);
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
			logger.info(e.getMessage());
		} finally {
			logger.info("Credit card validation process completed.");
		}
		
		FlightRoute flightRoute = null;
		Reservation reservation = null;
		try {
			flightRoute = new FlightRoute(0, airport, airport);
			Flight flight = new Flight(flightRoute, null, new Date(), new Date());
			reservation = new Reservation(flight, customer);
		} catch (NegativeValueException  e) {
			logger.info(e.getMessage());
		} finally {
			logger.info("Designation of new flight route complete.");
		}
		
        try (AutoCloseable laggageResource = () -> logger.info("Prepering for laggage registration...")) {
        	Laggage laggage = new Laggage(10);
        } catch (Exception e) {
        	logger.info(e.getMessage());
        } finally {
        	logger.info("Laggage registration process completed.");
        }
		
		
		try {
			LoyalityDiscount loyalityDiscount = new LoyalityDiscount(0, 0);
		} catch (NegativeValueException | InvalidPercentageException e) {
			logger.info(e.getMessage());
			e.printStackTrace();
		} finally {
			logger.info("Creating of new loyality discount completed.");
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
			logger.info(e.getMessage());
			e.printStackTrace();
		} finally {
			logger.info("Creating of new passenger plane completed.");
		}
		
		try {
			Payment payment = new Payment(0);
		} catch (NegativeValueException e) {
			logger.info(e.getMessage());
			e.printStackTrace();
		}
		
		try {
			PayPal payPal = new PayPal(false, "test@gmail.com");
		} catch (InvalidEmailException e) {
			logger.info(e.getMessage());
			e.printStackTrace();
		} finally {
			logger.info("Paypal validation process completed.");
		}
		
		try {
			SeasonalDiscount seasonalDiscount = new SeasonalDiscount(0, null, null);
		} catch (InvalidPercentageException e) {
			logger.info(e.getMessage());
			e.printStackTrace();
		} finally {
			logger.info("Creating of new seasonal discount completed.");
		}
		
		saveFile(countUniqueWords(readFile()));
		
		logger.info("works");
		
        Predicate<Flight> isDomestic = flight -> flight.getRoute().getEndAirport().getLocation().equals(flight.getRoute().getStartAirport().getLocation());

        Function<Double, Double> applyDiscount = price -> price * 0.9; // 10% discount

        Supplier<Airport> defaultAirport = () -> new Airport("Default Airport", "Location");

        Consumer<Flight> printFlightDetails = flight -> logger.info("Flight ID: " + flight.getUniqueId());

        BiFunction<Double, Integer, Double> calculateTotal = (pricePerSeat, numSeats) -> pricePerSeat * numSeats;
		
        Airport airport2 = defaultAirport.get();
        logger.info("Default Airport: " + airport.getName());

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
			logger.info("Is the flight domestic? " + isDomestic.test(flight2));
		} catch (NegativeValueException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.info("Discounted Price: " + applyDiscount.apply(100.0));
		logger.info("Total Price: " + calculateTotal.apply(50.0, 2));
        
        Comparator<Flight> sortByDeparture = (f1, f2) -> f1.getDepartureTime().compareTo(f2.getDepartureTime());

        BiFunction<Integer, Integer, Integer> addNumbers = (a, b) -> a + b;

        Predicate<List<?>> isListEmpty = List::isEmpty;

        logger.info("Is flight list empty? " + isListEmpty.test(flights));
        
        
        List<Flight> upcomingFlights = flights.stream()
        		.filter(flight -> flight.getDepartureTime().after(new Date()))
        	    .sorted(Comparator.comparing(Flight::getDepartureTime))
        	    .collect(Collectors.toList());

        upcomingFlights.forEach(flight -> logger.info(flight.getUniqueId()));
        	
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
	     	.forEach(employee -> logger.info(employee.getName()));
	    
	    List<Reservation> customerReservations = customer.getReservations();

	    int totalReservations = customerReservations.stream()
	        .filter(reservation2 -> reservation2.getCustomer().equals(customer))
	        .mapToInt(reservation2 -> 1)
	        .sum();

	    logger.info("Total reservations: " + totalReservations);
	    
	    List<CreditCard> creditCards = new ArrayList<>();
	    creditCards.add(creditCard);

	    long validCreditCardCount = creditCards.stream()
	    		.filter(creditCard2 -> creditCard2.getActive())
	    		.count();

	    logger.info("Valid Credit Cards: " + validCreditCardCount);
	    
	    List<FlightRoute> flightRoutes = new ArrayList<>();
	    flightRoutes.add(flightRoute);

	    Map<String, Long> airportFlightCounts = flightRoutes.stream()
	    		.filter(route -> route.getStartAirport().getLocation().equals("poland") || 
	                     route.getEndAirport().getLocation().equals("poland"))
	    		.map(route -> route.getStartAirport().getLocation())
	    		.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

	    airportFlightCounts.forEach((location, count) -> logger.info(location + ": " + count));
	    
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
                logger.info("Async Task got " + connection);
                Thread.sleep(1000);
                connectionPool.releaseConnection(connection);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        future.join();
        logger.info("Asynchronous task completed.");
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
        Logger logger = LogManager.getLogger(ConnectionPool.class);
        logger.info("Connection pool initialized with " + MAX_SIZE + " connections.");
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
        	Logger logger = LogManager.getLogger(ConnectionTask.class);
            Connection connection = connectionPool.getConnection();
            logger.info(Thread.currentThread().getName() + " got " + connection);
            Thread.sleep(2000);
            logger.info(Thread.currentThread().getName() + " released " + connection);
            connectionPool.releaseConnection(connection);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
/* 
switch all print with logger
*/
