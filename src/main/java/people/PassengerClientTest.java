package people;

import java.util.Scanner;

public class PassengerClientTest {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Passenger passenger = new Passenger();

        System.out.println("Enter username:");
        passenger.username = scanner.nextLine();
        System.out.println("Enter location:");
        passenger.location = scanner.nextLine();
        try{
            passenger.postPassenger();
            passenger.getDriverList();
            System.out.println("Enter selected driver:");
            String selectedDriver = scanner.nextLine();
            passenger.postSelection(selectedDriver);
        } catch (Exception e){
            e.printStackTrace();
        }

    }

}
