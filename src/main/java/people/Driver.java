package people;

import okhttp3.*;

import java.io.IOException;

public class Driver extends Person{
    private boolean isHired;

    private final OkHttpClient httpClient = new OkHttpClient();

    public boolean getIsHired() {
        return this.isHired;
    }

    public void setHired(boolean isHired) {
        this.isHired = isHired;
    }

    public boolean checkNotificationHired() {
        //if you are hired, than create a Ride, than after the Ride repeat
        //if not, repeat;
        return false;
    }


    public void postDriver() throws Exception {
        // form parameters
        Request request = new Request.Builder()
                .url("https://localhost:8080/passenger?"
                        + "username=" + username + "&location=" + location)
                .build();

        try (Response response = httpClient.newCall(request).execute()) {

            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

            // Get response body
            System.out.println(response.body().string());
        }

    }

}

