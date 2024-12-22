package main.java.com.solvd.airline;
import java.util.Date;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Flight implements IIdentifiable, IReservable, ITrackable {
    private static final Logger logger = LogManager.getLogger(Flight.class);
	private FlightRoute route;
	private Airplane airplane;
	private Date departureTime;
	private Date arrivalTime;
    private FlightStatus status;

	public Flight(FlightRoute route, Airplane airplane, Date departureTime, Date arrivalTime) {
		super();
		this.setAirplane(airplane);
		this.setRoute(route);
		this.setDepartureTime(departureTime);
		this.setArrivalTime(arrivalTime);
		this.setStatus(FlightStatus.SCHEDULED);
	}

	public Airplane getAirplane() {
		return airplane;
	}

	public void setAirplane(Airplane airplane) {
		this.airplane = airplane;
	}

	public Date getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(Date departureTime) {
		this.departureTime = departureTime;
	}

	public Date getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(Date arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public FlightRoute getRoute() {
		return route;
	}

	public void setRoute(FlightRoute route) {
		this.route = route;
	}
	
    public FlightStatus getStatus() {
        return status;
    }
	
    private void setStatus(FlightStatus status) {
        this.status = status;
    }

    @Override
    public void updateStatus(String status) {
        try {
            this.status = FlightStatus.valueOf(status.toUpperCase());
            logger.info("Flight status updated to: " + this.getStatus().getDescription());
        } catch (IllegalArgumentException e) {
        	logger.info("Invalid status: " + status);
        }
    }

	@Override
	public boolean reserve() {
		logger.info("Flight reserved: " + this.getUniqueId());
        return true;
	}

	@Override
	public boolean cancelReservation() {
		logger.info("Flight reservation canceled: " + this.getUniqueId());
        return true;
	}

	@Override
	public String getUniqueId() {
        return this.getRoute().getEndAirport().getUniqueId() + "-" + this.getDepartureTime().toString() + "-" + 
        		this.getAirplane() + "-" + this.getRoute().getEndAirport().getUniqueId() + "-" + this.getArrivalTime().toString();
	}
	
    public enum FlightStatus {
        SCHEDULED("The flight is scheduled and on time"),
        BOARDING("The flight is currently boarding"),
        IN_FLIGHT("The flight is currently in the air"),
        DELAYED("The flight is delayed"),
        CANCELLED("The flight has been cancelled");

        private final String description;

        FlightStatus(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }
    }
}
