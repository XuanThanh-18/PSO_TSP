//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.ArrayList;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        ArrayList<City> cities = FileUtils.readACityFromFile();
        Route route = new Route(cities);
        FileUtils.readCongigFromFile();
        PSOptimization pso = new PSOptimization(route);
        long startTime = System.nanoTime();
        pso.findShortestRoute();
        long endTime = System.nanoTime();
        String reslut = "";
        reslut = reslut + "\n============ Execution Time =========== \n";
        reslut = reslut + "Your algorithm runs : " + (double)(endTime - startTime) / 1.0E9 + "s\n";
        System.out.println(reslut);
        FileUtils.writeFile("src/Output/results.txt", reslut);
    }
}
