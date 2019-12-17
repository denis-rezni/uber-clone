package people;

import okhttp3.*;

import java.io.IOException;
import java.util.Scanner;

public class PassengerClientTest {
    String username;
    String location;

    private final OkHttpClient httpClient;

    public PassengerClientTest(){
        this.httpClient = new OkHttpClient();
    }

    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        Passenger myself = new Passenger();
        System.out.println("Enter username:");
        myself.username = scanner.nextLine();
        System.out.println("Enter location:");
        myself.location = scanner.nextLine();
        PassengerClientTest client = new PassengerClientTest();
        try{
            client.postPassenger(myself);
            client.getDriverList(myself);
            //display driver list
            System.out.println("Enter selected driver:");
            String selectedDriver = scanner.nextLine();
            //then need to check if the driver input is valid
            client.postSelection(myself, selectedDriver);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    private void getDriverList(Passenger passenger) throws Exception {
        Request request = new Request.Builder()
                .url("https://192.168.208.107:8080/" + "?location = "+ passenger.location)
                .build();

        try (Response response = httpClient.newCall(request).execute()) {

            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

            // Get response body
            System.out.println(response.body().string());
        }
    }

    private void postPassenger(Passenger passenger) throws Exception{
        // form parameters
        RequestBody formBody = new FormBody.Builder()
                .add("username", passenger.username)
                .add("location", passenger.location)
                .build();

        Request request = new Request.Builder()
                .url("https://192.168.208.107:8080/passenger?name="+passenger.username+"&location="+passenger.location)
                .post(formBody)
                .build();

        try (Response response = httpClient.newCall(request).execute()) {

            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

            // Get response body
            System.out.println(response.body().string());
        }

    }

    private void postSelection(Passenger passenger, String selectedDriver) throws Exception{
        // form parameters
        RequestBody formBody = new FormBody.Builder()
                .add("driver_username", selectedDriver)
                .add("passenger_username", passenger.username)
                .build();

        Request request = new Request.Builder()
                .url("https://192.168.208.107:8080")
                .post(formBody)
                .build();

        try (Response response = httpClient.newCall(request).execute()) {

            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

            // Get response body
            System.out.println(response.body().string());
        }
    }

}
