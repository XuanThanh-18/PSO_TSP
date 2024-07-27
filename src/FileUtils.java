//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileUtils {
    public FileUtils() {
    }

    public static ArrayList<City> readACityFromFile() {
        ArrayList<City> city = new ArrayList();
        String relativePath = "src/Input/tsp_example.txt";
        File file = new File(relativePath);
        if (!file.exists()) {
            System.out.println("File not exit: " + String.valueOf(file.getAbsoluteFile()));
        }

        try {
            Scanner input = new Scanner(file);

            while(input.hasNextLine()) {
                String line = input.nextLine();
                String[] arrLine = line.split(" ");
                city.add(new City(Double.parseDouble(arrLine[1]), Double.parseDouble(arrLine[2]), arrLine[0]));
            }
        } catch (FileNotFoundException var6) {
            var6.printStackTrace();
        }

        return city;
    }

    public static void readCongigFromFile() {
        String filepath = "src/Input/PSO_Params.txt";

        try {
            BufferedReader br = new BufferedReader(new FileReader(filepath));

            String line;
            while((line = br.readLine()) != null) {
                String[] parts = line.split(":");
                if (parts.length == 2) {
                    String key = parts[0].trim();
                    String value = parts[1].trim();
                    switch (key) {
                        case "maximumParticles":
                            PSOptimization.maximumParticles = Integer.parseInt(value);
                            break;
                        case "maximumIterations":
                            PSOptimization.maximumIterations = Integer.parseInt(value);
                            break;
                        case "c1":
                            PSOptimization.c1 = Double.parseDouble(value);
                            break;
                        case "c2":
                            PSOptimization.c2 = Double.parseDouble(value);
                            break;
                        case "low":
                            PSOptimization.low = Double.parseDouble(value);
                            break;
                        case "hight":
                            PSOptimization.high = Double.parseDouble(value);
                    }
                }
            }
        } catch (FileNotFoundException var8) {
            var8.printStackTrace();
        } catch (IOException var9) {
            var9.printStackTrace();
        }

    }

    public static void clearFile(String filePath) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(filePath));
            bw.close();
        } catch (IOException var2) {
            var2.printStackTrace();
        }

    }

    public static void writeFile(String filePath, String content) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(filePath, true));

            try {
                bw.write(content);
                bw.newLine();
            } catch (Throwable var6) {
                try {
                    bw.close();
                } catch (Throwable var5) {
                    var6.addSuppressed(var5);
                }

                throw var6;
            }

            bw.close();
        } catch (IOException var7) {
            var7.printStackTrace();
        }

    }
}
