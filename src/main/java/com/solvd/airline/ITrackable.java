package main.java.com.solvd.airline;

import main.java.com.solvd.airline.Flight.FlightStatus;

public interface ITrackable {
    FlightStatus getStatus();
    void updateStatus(String status);
}
