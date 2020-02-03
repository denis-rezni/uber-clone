package server;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import people.Driver;
import people.Passenger;

import java.util.ArrayList;
import java.util.List;

@RestController
public class RideController {

    List<Passenger> passengers = new ArrayList<>();
    List<Driver> drivers = new ArrayList<>();

    @GetMapping("/drivers")
    public List<Driver> driversGET(@RequestParam(value = "location", defaultValue = "Nowhere") String location) {

        List<Driver> driversAtLoc = new ArrayList<>();

        for (Driver driver : drivers)
            if (driver.getLocation().equals(location) && !driver.IsHired()) {
                driversAtLoc.add(driver);
            }
        return driversAtLoc;
    }

    @PostMapping("/driver")
    public boolean createDriver(@RequestParam(value = "username", defaultValue = "Team2") String name,
                                @RequestParam(value = "location", defaultValue = "Brighton") String location) {

        for (Driver driver1 : drivers)
            if (driver1.getUsername().equals(name))
                return false;

        for (Passenger passenger : passengers)
            if (passenger.getUsername().equals(name))
                return false;

        Driver driver = new Driver();
        driver.setLocation(location);
        driver.setUsername(name);
        System.out.println("new driver");
        System.out.println(name);
        System.out.println(location);
        drivers.add(driver);
        System.out.println(drivers.size());

        return true;
    }

    @PostMapping("/passenger")
    public boolean createPassenger(@RequestParam(value = "username", defaultValue = "Team2") String name,
                                   @RequestParam(value = "location", defaultValue = "Brighton") String location) {

        for (Driver driver : drivers)
            if (driver.getUsername().equals(name))
                return false;

        for (Passenger passenger : passengers)
            if (passenger.getUsername().equals(name))
                return false;
        Passenger passenger = new Passenger();
        passenger.setLocation(location);
        passenger.setUsername(name);
        System.out.println("new passenger");
        System.out.println(name);
        System.out.println(location);
        passengers.add(passenger);
        System.out.println(passengers.size());

        return true;
    }

    @GetMapping("/checkNotification")
    public boolean checkIfHired(@RequestParam(value = "username", defaultValue = "Team2") String driverName) {
        for (Driver driver : drivers) {
            if (driver.getUsername().equals(driverName) && driver.IsHired()) {
                return true;
            }
        }
        return false;
    }

    @PostMapping("/hire")
    public void hireADriver(@RequestParam(value = "username", defaultValue = "Team2") String driverName) {
        for (Driver driver : drivers) {
            if (driver.getUsername().equals(driverName)) {
                driver.setHired(true);
                break;
            }
        }
    }


}
