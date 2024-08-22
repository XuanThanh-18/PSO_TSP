//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.ArrayList;
import java.util.Iterator;

public class Route {
    private ArrayList<City> cities = new ArrayList();

    public Route(ArrayList<City> cities) {
        this.cities = cities;
    }

    public ArrayList<City> getCities() {
        return this.cities;
    }

    public Route(Route route) {
        for(int i = 0; i < route.cities.size(); ++i) {
            this.cities.add((City)route.cities.get(i));
        }

    }

    public double getFullRouteDistance() {
        double fullDistance = 0.0;

        for(int i = 0; i < this.cities.size(); ++i) {
            if (i + 1 == this.cities.size()) {
                fullDistance += ((City)this.cities.get(i)).distanceBetweenTwoCities((City)this.cities.get(0));
            } else {
                fullDistance += ((City)this.cities.get(i)).distanceBetweenTwoCities((City)this.cities.get(i + 1));
            }
        }

        return fullDistance;
    }

    public String getRoute() {
        String str = "";
        str = str + "{ ";

        City city;
        for(Iterator var2 = this.cities.iterator(); var2.hasNext(); str = str + city.name + " ") {
            city = (City)var2.next();
        }

        str = str + " }";
        return str;
    }

    @Override
    public String toString() {
        return  cities +" ";
    }
}