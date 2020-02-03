package test;
import okhttp3.*;

import java.io.IOException;

public class PostRequestTests {

    public static void main(String[] args) {
        OkHttpClient client = new OkHttpClient();

        RequestBody formBody = new FormBody.Builder()
                .add("username", "denis")
                .add("location", "spb")
                .build();

        Request req = new Request.Builder()
                .url("http://localhost:8080/passenger")
                .post(formBody)
                .build();
        System.out.println(req);

        try {
            Response response = client.newCall(req).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
