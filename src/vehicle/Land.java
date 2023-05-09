/*
package vehicle;

*/
/**
 * The Land class is an abstract class that extends the Vehicle class and represents a land-based vehicle.
 * It contains the properties and methods common to all land-based vehicles.
 *//*

import javax.swing.*;
import java.util.Objects;

public abstract class Land extends Vehicle{
    protected int wheels;
    protected String roadType;

    */
/**
     * Constructs a new Land object with the specified model, maximum passengers, maximum speed, number of wheels, and road type.
     * @param model The model of the land-based vehicle.
     * @param maxPassengers The maximum number of passengers that can be carried by the land-based vehicle.
     * @param maxSpeed The maximum speed of the land-based vehicle.
     * @param wheels The number of wheels of the land-based vehicle.
     * @param roadType The type of road the land-based vehicle can move on.
     *//*

    public Land(String model, int maxPassengers, int maxSpeed, int wheels, String roadType, ImageIcon img) {
        super(model, maxPassengers, maxSpeed);
        this.roadType = roadType;
        this.wheels = wheels;
    }

    public int getWheels() {
        return wheels;
    }

    */
/**
     * Sets the number of wheels of the land-based vehicle.
     * @param wheels The new number of wheels of the land-based vehicle.
     *//*

    public void setWheels(int wheels) {
        this.wheels = wheels;
    }

    public String getRoadType() {
        return roadType;
    }

    */
/**
     * Sets the type of road the land-based vehicle can move on.
     * @param roadType The new type of road the land-based vehicle can move on.
     *//*

    public void setRoadType(String roadType) {
        this.roadType = roadType;
    }

    */
/**
     * *  toString method to represent a Land object.
     * @return A string representation of the Land object.
     *//*

    @Override
    public String toString() {
        return super.toString() +
                " It has " + wheels +
                " wheels. Can move on " + roadType;
    }

    */
/**
     * Checks if the current Land object is equal to another object.
     * @param o The object to compare with.
     * @return True if the objects are equal, false otherwise.
     *//*

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Land land = (Land) o;
        return wheels == land.wheels && Objects.equals(roadType, land.roadType);
    }
}
*/
