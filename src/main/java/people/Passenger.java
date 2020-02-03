package people;

import okhttp3.*;

import java.io.IOException;

public class Passenger extends Person{
    private final OkHttpClient httpClient = new OkHttpClient();

    public static void main(String[] args) {
        Passenger myself = new Passenger();
    }


}
