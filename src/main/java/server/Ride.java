package server;

import people.Driver;
import people.Passenger;

public class Ride {
    Passenger passenger;
    Driver driver;

    public Ride(Passenger passenger, Driver driver) {
        this.passenger = passenger;
        this.driver = driver;
    }
}
