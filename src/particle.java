//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.ArrayList;

public class particle {
    private Route route;
    private Location location;
    private Velocity velocity;
    private Route pBest;
    private Location locationPBest;
    public static int problemSize;
    public static int maximumIterations = 100;

    public particle(Route route) {
        this.route = route;
        this.pBest = route;
        this.location = new Location(new ArrayList());
        this.locationPBest = new Location(new ArrayList());
        this.velocity = new Velocity(new ArrayList());
        problemSize = route.getCities().size();
    }

    public void getBest() {
        Route neighborRoute = null;

        for(int i = 0; i < maximumIterations; ++i) {
            neighborRoute = this.getNeighborhoodSolution(new Route(this.pBest));
            if (neighborRoute.getFullRouteDistance() < this.pBest.getFullRouteDistance()) {
                this.pBest = new Route(neighborRoute);
            }
        }

    }

    public Route getNeighborhoodSolution(Route aRoute) { // tao ra route mới băng cách hoan doi 2 vi tri ngua nhien
        int random1 = 0;

        int random2;
        for(random2 = 0; random2 == random1; random2 = (int)((double)aRoute.getCities().size() * Math.random())) {
            random1 = (int)((double)aRoute.getCities().size() * Math.random());
        }

        City city1 = (City)aRoute.getCities().get(random1);
        City city2 = (City)aRoute.getCities().get(random2);
        aRoute.getCities().set(random2, city1);
        aRoute.getCities().set(random1, city2);
        return aRoute;
    }

    public void swapWithLocation(int coeff) {
        for(int i = 0; i < coeff; ++i) {
            int random1 = 0;

            int random2;
            for(random2 = 0; random1 == random2; random2 = (int)((double)this.pBest.getCities().size() * Math.random())) {
                random1 = (int)((double)this.pBest.getCities().size() * Math.random());
            }

            City city1 = (City)this.pBest.getCities().get(random1);
            City city2 = (City)this.pBest.getCities().get(random2);
            this.pBest.getCities().set(random2, city1);
            this.pBest.getCities().set(random2, city2);
        }

    }

    public Route getRoute() {
        return this.route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public Location getLocation() {
        return this.location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Velocity getVelocity() {
        return this.velocity;
    }

    public void setVelocity(Velocity velocity) {
        this.velocity = velocity;
    }

    public Route getpBest() {
        return this.pBest;
    }

    public void setpBest(Route pBest) {
        this.pBest = pBest;
    }

    public Location getLocationPBest() {
        return this.locationPBest;
    }

    public void setLocationPBest(Location locationPBest) {
        this.locationPBest = locationPBest;
    }

    @Override
    public String toString() {
        return "particle{" +
                "route=" + route + "\t Value: "+route.getFullRouteDistance()+
                "\n, location=" + location +
                "\n, velocity=" + velocity +
                "\n, pBest=" + pBest +
                "\n, locationPBest=" + locationPBest +
                '}';
    }
}