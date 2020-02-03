package people;

public abstract class Person {
    final static String urlBeginning = "http://localhost:8080/";
    String username;
    String location;

    public void setUsername(String username) {
        this.username = username;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getUsername() {
        return username;
    }

    public String getLocation() {
        return location;
    }

}
