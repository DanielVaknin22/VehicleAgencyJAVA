package vehicle;

import javax.swing.*;

public class Bicycle extends Vehicle implements noMotorized, ILand{

    private String power;
    private energyScore energy;
    private int wheels;
    private String roadType;

    /**
     * Constructs a new Vehicle object with the given model, maximum number of passengers, and maximum speed.
     *
     * @param model the model of the vehicle
     * @param maxPassengers the maximum number of passengers the vehicle can carry
     * @param maxSpeed the maximum speed of the vehicle
     * @param img The img of the Bicycle.
     */
    public Bicycle(String model, int maxPassengers, int maxSpeed, String roadType, ImageIcon img) {
        super(model, maxPassengers, maxSpeed,img);
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

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + ":" + "<br>" + super.toString() +
                "<br>" + " The power source is: " + power +
                "<br>" + " The energy score is: " + energy +
                "<br>" + " It has " + wheels + "wheels." +
                "<br>" + "Can move on" + roadType + ".";
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
