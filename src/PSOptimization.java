//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Random;

public class PSOptimization {
    public static int maximumParticles;
    public static int maximumIterations;
    public static double c1;
    public static double c2;
    public static double low;
    public static double high;
    public Random random = new Random();
    public ArrayList<particle> particlesList = new ArrayList();
    public Route gBest = null;
    public Location gBestLocation;

    public PSOptimization(Route route) {
        System.out.println("Initial distance: " + (int)route.getFullRouteDistance() + " km");
        System.out.println(route.getRoute());
        System.out.println("\n");
        System.out.println("========================= Initializing Particles ... =======================\n");

        for(int i = 0; i < maximumParticles; ++i) {
            Collections.shuffle(route.getCities());
            this.particlesList.add(new particle(new Route(route)));
        }

        this.gBestLocation = new Location(new ArrayList());
        this.initilizeVelocities();
        this.initilizeLocations();
        this.sort();
        this.gBest = new Route(((particle)this.particlesList.get(0)).getpBest());
        System.out.println("======= " + maximumParticles + " Particles are Initialized Uniformly ! ============");
        System.out.println();
    }

    public void initilizeVelocities() {
        Iterator var1 = this.particlesList.iterator();

        while(var1.hasNext()) {
            particle p = (particle)var1.next();

            for(int i = 0; i < particle.problemSize - 1; ++i) {
                p.getVelocity().velocityDimensions.add(this.random.nextDouble() * 2.0 - 1.0);
            }
        }

    }

    public void initilizeLocations() {
        Iterator var1 = this.particlesList.iterator();

        while(var1.hasNext()) {
            particle p = (particle)var1.next();

            for(int i = 0; i < particle.problemSize - 1; ++i) {
                p.getLocation().getLocations().add((double)i);
                p.getLocationPBest().getLocations().add((double)i);
            }
        }

        for(int i = 0; i < particle.problemSize - 1; ++i) {
            this.gBestLocation.getLocations().add((double)i);
        }

    }

    public void sort() {
        int n = this.particlesList.size();

        for(int i = 0; i < n - 1; ++i) {
            for(int j = 0; j < n - i - 1; ++j) {
                if (((particle)this.particlesList.get(j)).getpBest().getFullRouteDistance() > ((particle)this.particlesList.get(j + 1)).getpBest().getFullRouteDistance()) {
                    particle temp = (particle)this.particlesList.get(j);
                    this.particlesList.set(j, (particle)this.particlesList.get(j + 1));
                    this.particlesList.set(j + 1, temp);
                }
            }
        }

    }

    public void findShortestRoute() {
        System.out.println("========================= Starting Process =======================");
        System.out.println();
        double w = 0.0;

        for(int counter = 0; counter < maximumIterations; ++counter) {
            int i;
            for(i = 0; i < this.particlesList.size() - 1; ++i) {
                ((particle)this.particlesList.get(i)).getBest();
            }

            this.printParticles();
            this.sort();
            if (((particle)this.particlesList.get(0)).getpBest().getFullRouteDistance() < this.gBest.getFullRouteDistance()) {
                this.gBest = new Route(((particle)this.particlesList.get(0)).getpBest());
            }

            System.out.println("Actual gBest = " + (int)this.gBest.getFullRouteDistance() + " km");
            w = high - (double)counter / (double)maximumIterations * (high - low);
            System.out.println("Updating Velocities and Locations ...");

            for(i = 0; i < this.particlesList.size() - 1; ++i) {
                for(int j = 0; j < particle.problemSize - 1; ++j) {
                    double r1 = this.random.nextDouble();
                    double r2 = this.random.nextDouble();
                    double vel = (Double)((particle)this.particlesList.get(i)).getVelocity().getVelocityDimensions().get(j);
                    double loc = (Double)((particle)this.particlesList.get(i)).getLocation().getLocations().get(j);
                    double pBestLoc = (Double)((particle)this.particlesList.get(i)).getLocationPBest().getLocations().get(j);
                    double gBestLoc = (Double)this.gBestLocation.getLocations().get(j);
                    double newVel = w * vel + r1 * c1 * (pBestLoc - loc) + r2 * c2 * (gBestLoc - loc);
                    ((particle)this.particlesList.get(i)).getVelocity().getVelocityDimensions().set(j, newVel);
                    double newPos = loc + newVel;
                    ((particle)this.particlesList.get(i)).getLocation().getLocations().set(j, newPos);
                    ((particle)this.particlesList.get(i)).swapWithLocation((int)Math.abs(loc - newPos));
                }
            }

            System.out.println("Epoch " + counter + " has been finished");
        }

        String reslut = "";
        FileUtils.clearFile("src/Output/results.txt");
        reslut = reslut + "\n========================= Process Finished =======================\n";
        reslut = reslut + "Approached Global minimum : " + (int)this.gBest.getFullRouteDistance() + " km\n";
        reslut = reslut + "Route : " + this.gBest.getRoute();
        System.out.println(reslut);
        FileUtils.writeFile("src/Output/results.txt", reslut);
    }

    public void printParticles() {
        for(int i = 0; i < this.particlesList.size() - 1; ++i) {
            System.out.println("Particle : " + i);

            for(int j = 0; j < particle.problemSize - 1; ++j) {
                PrintStream var10000 = System.out;
                String var10001 = String.valueOf(((particle)this.particlesList.get(i)).getLocation().getLocations().get(j));
                var10000.print("Position : " + var10001 + " , Velocity : " + String.valueOf(((particle)this.particlesList.get(i)).getVelocity().getVelocityDimensions().get(j)));
                System.out.println();
            }
        }

    }
}
