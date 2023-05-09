package vehicle;

import javax.swing.*;
import java.util.Objects;

public class Amphibious extends Vehicle implements IMarine, ILand, Motorized{
    private boolean withWind;
    private String flag;
    private int wheels;
    private String roadType;
    private float fuel;
    private float life;

    /**
     * Constructs a new Vehicle object with the given model, maximum number of passengers, and maximum speed.
     *
     * @param model         the model of the vehicle
     * @param maxPassengers the maximum number of passengers the vehicle can carry
     * @param maxSpeed      the maximum speed of the vehicle
     */
    public Amphibious(String model, int maxPassengers, int maxSpeed, int wheels, String flag, boolean withWind, float fuel, float life, ImageIcon img) {
        super(model, maxPassengers, maxSpeed,img);
        this.roadType = "paved";
        this.flag = flag;
        this.withWind = withWind;
        this.wheels = wheels;
        this.fuel = fuel;
        this.life = life;
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
    public boolean isWithWind() {
        return withWind;
    }

    @Override
    public void setWithWind(boolean withWind) {
        this.withWind = withWind;
    }

    @Override
    public String getFlag() {
        return flag;
    }

    @Override
    public void setFlag(String flag) {
        this.flag = flag;
    }

    @Override
    public void setAverageFuel(float fuel) {
        this.fuel = fuel;
    }

    @Override
    public void setAverageLife(float life) {
        this.life = life;
    }

    @Override
    public float getAverageFuel() {
        return fuel;
    }

    @Override
    public float getAverageLife() {
        return life;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Amphibious that = (Amphibious) o;
        return withWind == that.withWind && wheels == that.wheels && Float.compare(that.fuel, fuel) == 0 && Float.compare(that.life, life) == 0 && flag.equals(that.flag) && roadType.equals(that.roadType);
    }

    @Override
    public String toString() {
        String wind = withWind? " with": " without";
        return this.getClass().getSimpleName() + ": " + super.toString() +
                " Under " + flag + " flag, " + wind + " the wind." +
                " It has " + wheels +
                " wheels. Can move on " + roadType +
                " The average fuel is: " + fuel +
                " The average life is: " + life + ".";
    }
}
