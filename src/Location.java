//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.ArrayList;

public class Location {
    private ArrayList<Double> locations = new ArrayList();

    public Location(ArrayList<Double> locations) {
        this.locations = locations;
    }

    public ArrayList<Double> getLocations() {
        return this.locations;
    }

    public void updateLocation(ArrayList<Double> update) {
        this.locations.addAll(update);
    }
}
