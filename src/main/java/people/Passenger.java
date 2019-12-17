package people;
import okhttp3.*;

import java.io.IOException;

public class Passenger {
    String username;
    String location;
    private final OkHttpClient httpClient = new OkHttpClient();
    public static void main(String args[]){

        Passenger myself = new Passenger();
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return username;
    }

    public void setLocation(String location) {
        this.location = location;
    }


}
