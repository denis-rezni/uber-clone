package people;

import okhttp3.*;

import java.io.IOException;

public class Driver {

    String username;
    String location;
    boolean isHired;

    private final OkHttpClient httpClient = new OkHttpClient();

    public void setUsername(String username) {
        this.username = username;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public boolean getIsHired() {
        return this.isHired;
    }

    public void setHired(boolean isHired) {
        this.isHired = isHired;
    }

    public boolean checkNotificationHired() {
        //if you are hired, than create a Ride, than agfter the Ride repeat
        //if not, repeat;
        return false;
    }


    public void postDriver() throws Exception{
        // form parameters
        Request request = new Request.Builder()
                .url("https://192.168.208.107:8080/passenger?"
                        + "username=" + username + "&location=" + location)
                .build();

        try (Response response = httpClient.newCall(request).execute()) {

            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

            // Get response body
            System.out.println(response.body().string());
        }

    }

    public String getLocation() {
        return location;
    }
    public String getName() {
        return username;
    }
}

