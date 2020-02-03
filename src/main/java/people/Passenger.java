package people;

import okhttp3.*;

import java.io.IOException;

public class Passenger extends Person {
    private final OkHttpClient httpClient = new OkHttpClient();

    void getDriverList() {
        Request request = new Request.Builder()
                .url(urlBeginning + "drivers?location=" + this.getLocation())
                .build();

        try (Response response = httpClient.newCall(request).execute()) {

            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

            // Get response body
            System.out.println(response.body().string());
        } catch (Exception e) {
            System.out.println("failed to get the driver list");
            e.printStackTrace();
        }
    }

    void postPassenger() {
        RequestBody formBody = new FormBody.Builder()
                .add("username", this.getUsername())
                .add("location", this.getLocation())
                .build();

        Request request = new Request.Builder()
                .url(urlBeginning + "passenger")
                .post(formBody)
                .build();


        try {
            Response response = httpClient.newCall(request).execute();
            System.out.println("New passenger is posted: " + response.body().string());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    void postSelection(String selectedDriver) {
        // form parameters
        RequestBody formBody = new FormBody.Builder()
                .add("driver_username", selectedDriver)
                .add("passenger_username", this.getUsername())
                .build();

        Request request = new Request.Builder()
                .url(urlBeginning + "hire")
                .post(formBody)
                .build();

        try {
            Response response = httpClient.newCall(request).execute();
            System.out.println(response.body().string());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
