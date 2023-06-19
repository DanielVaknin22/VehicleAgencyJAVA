package vehicle;

import javax.swing.*;
import java.awt.*;

public class Bicycle extends Vehicle implements noMotorized, ILand{

    private String power;
    private energyScore energy;
    private int wheels;
    private String roadType;

    /**
     * Constructs a new Bicycle object with the given model, maximum number of passengers, maximum speed,
     * road type, and image.
     * @param model the model of the bicycle
     * @param maxPassengers the maximum number of passengers the bicycle can carry
     * @param maxSpeed the maximum speed of the bicycle
     * @param roadType the type of road the bicycle is suitable for
     * @param img the image representing the bicycle
     */
    public Bicycle(String model, int maxPassengers, int maxSpeed, String roadType, ImageIcon img, Color color) {
        super(model, maxPassengers, maxSpeed,img, color);
        this.roadType = roadType;
        this.energy = energyScore.A;
        this.power = "manual";
        this.wheels = 2;
    }

    @Override
    public int getWheels() {
        return wheels;
    }

    @Override
    public void setWheels(int wheels) {
        this.wheels = wheels;
    }

    @Override
    public String getRoadType() {
        return roadType;
    }

    @Override
    public void setRoadType(String roadType) {
        this.roadType = roadType;
    }

    @Override
    public void setPowerSource(String power) {
        this.power = power;
    }
    @Override
    public void setEnergyScore(energyScore energy) {
        this.energy = energy;
    }

    @Override
    public String getPowerSource() {
        return power;
    }

    @Override
    public energyScore getEnergyScore() {
        return energy;
    }

    /**
     *  toString method to represent a Bicycle object.
     * @return a string representation of the Bicycle object.
     */
    @Override
    public String toString() {
        return this.getClass().getSimpleName() + ":" + super.toString() +
                " The power source is: " + power +
                " The energy score is: " + energy +
                " It has " + wheels + "wheels." +
                "Can move on" + roadType + ".";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Bicycle bicycle = (Bicycle) o;
        return power.equals(bicycle.power) &&  (energy == bicycle.energy) && (wheels == bicycle.wheels) && (roadType.equals(bicycle.roadType));
    }
}
