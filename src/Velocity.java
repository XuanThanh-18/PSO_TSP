//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.ArrayList;

public class Velocity {
    public ArrayList<Double> velocityDimensions;

    public Velocity(ArrayList<Double> dimensions) {
        this.velocityDimensions = dimensions;
    }

    public ArrayList<Double> getVelocityDimensions() {
        return this.velocityDimensions;
    }

    public void updateVelocity(ArrayList<Double> update) {
        this.velocityDimensions.addAll(update);
    }
}
