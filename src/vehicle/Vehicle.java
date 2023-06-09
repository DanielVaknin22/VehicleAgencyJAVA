package vehicle;
/**
 * The Vehicle class represents a generic vehicle with a model name, distance traveled, maximum number of passengers, and maximum speed.
 */
import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public abstract class Vehicle {
    protected String model;
    protected int km;
    protected int maxPassengers;
    protected int maxSpeed;
    protected ImageIcon img;
    protected int inBuyProcess;
    protected int testDrive;
    protected Color color;

    /**
     * Constructs a new Vehicle object with the given model, maximum number of passengers, and maximum speed.
     *
     * @param model         the model of the vehicle
     * @param maxPassengers the maximum number of passengers the vehicle can carry
     * @param maxSpeed      the maximum speed of the vehicle
     */
    public Vehicle(String model, int maxPassengers, int maxSpeed, ImageIcon img, Color color) {
        this.model = model;
        this.km = 0;
        this.inBuyProcess = 0;
        this.testDrive = 0;
        this.maxPassengers = maxPassengers;
        this.maxSpeed = maxSpeed;
        this.img = img;
        this.color = color;
    }

    public Color getColor() {
        return this.color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public ImageIcon getImg() {
        return this.img;
    }

    public void startTest() {
        this.testDrive = 1;
    }

    public void endTest() {
        this.testDrive = 0;
    }

    public boolean getTest() {
        return this.testDrive == 1;
    }

    public void startBuying() {
        this.inBuyProcess = 1;
    }

    public void endBuying() {
        this.inBuyProcess = 0;
    }

    public boolean getBuying() {
        return this.inBuyProcess == 1;
    }

    /**
     * Moves the vehicle a given distance in kilometers.
     *
     * @param distance the distance to move the vehicle in kilometers
     */
    public void Move(int distance) {
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

    public void setStatus(){ }

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

    /**
     * toString method for vehicle objects. a string representation of the vehicle, including its model, distance traveled, maximum speed,
     * and maximum number of passengers.
     *
     * @return a string representation of the vehicle.
     */
    @Override
    public String toString() {
        return "Model: " + model +
                "test: " + testDrive +
                "\n traveled: " + km +
                ", Max speed of " + maxSpeed +
                ", can carry max of " + maxPassengers + " people.";
    }

    /**
     * Determines Vehicle object are equal to another Vehicle object by comparing all data members.
     *
     * @param o the object to compare to this one
     * @return true if this object is the same as the o argument; false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return km == vehicle.km && maxPassengers == vehicle.maxPassengers && maxSpeed == vehicle.maxSpeed && Objects.equals(model, vehicle.model);
    }
}
