package vehicle;

import java.util.Objects;

public abstract class Land extends Vehicle{
    protected int wheels;
    protected String roadType;

    public Land(String model, int maxPassengers, int maxSpeed, int wheels, String roadType) {
        super(model, maxPassengers, maxSpeed);
        this.roadType = roadType;
        this.wheels = wheels;
    }

    public int getWheels() {
        return wheels;
    }

    public void setWheels(int wheels) {
        this.wheels = wheels;
    }

    public String getRoadType() {
        return roadType;
    }

    public void setRoadType(String roadType) {
        this.roadType = roadType;
    }

    @Override
    public String toString() {
        return super.toString() +
                " It has " + wheels +
                " wheels. Can move on " + roadType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Land land = (Land) o;
        return wheels == land.wheels && Objects.equals(roadType, land.roadType);
    }
}
