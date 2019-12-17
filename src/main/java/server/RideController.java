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
    public List<Driver> driversGET(@RequestParam(value = "location", defaultValue = "Nothing") String location) {

        List<Driver> driverAtLoc = new ArrayList<>();

        for (int i = 0; i < drivers.size(); i++)
            if (drivers.get(i).getLocation().equals(location))
                driverAtLoc.add(drivers.get(i));
        return driverAtLoc;
    }

    @PostMapping("/driver")
    public boolean createDriver(@RequestParam(value = "username", defaultValue = "Team2") String name,
                                @RequestParam(value = "location", defaultValue = "Brighton") String location) {

        for (Driver driver1 : drivers)
            if (driver1.getName().equals(name))
                return false;

        for (Passenger passenger : passengers)
            if (passenger.getName().equals(name))
                return false;

        Driver driver = new Driver();
        driver.setLocation(location);
        driver.setUsername(name);
        System.out.println(name);
        System.out.println(location);
        drivers.add(driver);
        System.out.println(passengers.size());

        return true;
    }

    @PostMapping("/passenger")
    public boolean createPassenger(@RequestParam(value = "username", defaultValue = "Team2") String name,
                                   @RequestParam(value = "location", defaultValue = "Brighton") String location) {

        Driver mark = new Driver();
        mark.setUsername("mark");
        drivers.add(mark);

        for (Driver driver : drivers)
            if (driver.getName().equals(name))
                return false;

        for (Passenger passenger : passengers)
            if (passenger.getName().equals(name))
                return false;
        Passenger pas = new Passenger();
        pas.setLocation(location);
        pas.setUsername(name);
        System.out.println(name);
        System.out.println(location);
        passengers.add(pas);
        System.out.println(passengers.size());

        return true;
    }

    @GetMapping("/checkNotification")
    public boolean checkIfHired(@RequestParam(value = "username", defaultValue = "Team2") String driverName) {
        for (Driver driver : drivers) {
            if (driver.getName().equals(driverName) && driver.getIsHired()) {
                return true;
            }
        }
        return false;
    }

    @PostMapping("/hire")
    public void hireADriver(@RequestParam(value = "username", defaultValue = "Team2") String driverName) {
        for (Driver driver : drivers) {
            if (driver.getName().equals(driverName)) {
                driver.setHired(true);
            }
        }
    }


}
