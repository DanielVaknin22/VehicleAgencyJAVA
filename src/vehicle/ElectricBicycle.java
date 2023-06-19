package vehicle;

import javax.swing.*;
import java.awt.*;

public class ElectricBicycle extends Vehicle implements ILand, Motorized {
    private int wheels;
    private float fuel;
    private float life;
    private String roadType;

    public ElectricBicycle(String model, int maxPassengers, int maxSpeed, String roadType, float life, ImageIcon img, Color color){
        super(model,maxPassengers,maxSpeed,img, color);
        this.roadType = roadType;
        this.wheels = 2;
        this.fuel = 20;
        this.life = life;
    }

    @Override
    public int getWheels() { return wheels; }

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
    public void setAverageFuel(float fuel) { this.fuel = fuel; }

    @Override
    public void setAverageLife(float life) { this.life = life;}

    @Override
    public float getAverageFuel() { return fuel; }

    @Override
    public float getAverageLife() { return life; }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + ":" + super.toString() +
                " It has " + wheels + " wheels." +
                "Can move on " + roadType +
                " The average fuel is: " + fuel +
                " The average life is: " + life + ".";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ElectricBicycle electricBicycle = (ElectricBicycle) o;
        return wheels == electricBicycle.wheels && Float.compare(electricBicycle.fuel, fuel) == 0 && Float.compare(electricBicycle.life, life) == 0 && roadType.equals(electricBicycle.roadType); }
}
