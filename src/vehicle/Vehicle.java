package vehicle;

import java.util.Objects;

public abstract class Vehicle {
    protected String model;
    protected int km;
    protected int maxPassengers;
    protected int maxSpeed;

    public Vehicle(String model, int maxPassengers, int maxSpeed) {
        this.model = model;
        this.km = 0;
        this.maxPassengers = maxPassengers;
        this.maxSpeed = maxSpeed;
    }

    public void Move(int distance){
        this.km += distance;
    }

    public String getModel() {
        return model;
    }

    public int getKm() {
        return km;
    }

    public int getMaxPassengers() {
        return maxPassengers;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setKm(int km) {
        this.km = km;
    }

    public void setMaxPassengers(int maxPassengers) {
        this.maxPassengers = maxPassengers;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    @Override
    public String toString() {
        return "Model: " + model +
                ", traveled: " + km +
                ", Max speed of " + maxSpeed +
                ", can carry max of " + maxPassengers + " people.";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return km == vehicle.km && maxPassengers == vehicle.maxPassengers && maxSpeed == vehicle.maxSpeed && Objects.equals(model, vehicle.model);
    }
}
