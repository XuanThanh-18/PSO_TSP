//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

public class City {
    public double latitude;
    public double longitude;
    public String name;

    public City() {
    }

    public City(double latitude, double longitude, String name) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.name = name;
    }

    public double distanceBetweenTwoCities(City other) {
        return Math.sqrt(Math.pow(this.latitude - other.latitude, 2.0) + Math.pow(this.longitude - other.longitude, 2.0));
    }
}
