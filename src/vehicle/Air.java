/*
package vehicle;

import java.util.Objects;
*/
/**

 Air class represents a type of air transport vehicle.
 It extends the Vehicle class and adds a "Use" field to represent the purpose for using the vehicle.
 *//*

public abstract class Air extends Vehicle {
    protected String use;
    */
/**
     * Constructs an Air object with a given model, maximum number of passengers, maximum speed, and use information.
     * @param model the model of the vehicle.
     * @param maxPassengers the maximum number of passengers the vehicle can hold.
     * @param maxSpeed the maximum speed of the vehicle.
     * @param use the intended use of the vehicle.
     *//*

    public Air(String model, int maxPassengers, int maxSpeed, String use) {
        super(model, maxPassengers, maxSpeed);
        this.use = use;
    }

    */
/**
     * @return the use of the vehicle
     *//*

    public String getUse() {
        return use;
    }

    */
/**
     * Sets the intended use of the vehicle.
     * @param use the new use of the vehicle
     *//*

    public void setUse(String use) {
        this.use = use;
    }

    */
/**
     * Returns a string representation of the Air object, including the
     * vehicle model, maximum number of passengers, maximum speed, and use.
     *
     * @return a string representation of the Air object
     *//*

    @Override
    public String toString() {
        return super.toString() + " It is used for:" + use;
    }

    */
/**
     * Determines if this Air object is equal to another Air object.
     * Two Air objects are considered equal if they have the same model,
     * maximum number of passengers, maximum speed, and use.
     *
     * @param o the object to compare to this Air object
     * @return true if the objects are equal, false otherwise
     *//*

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Air air = (Air) o;
        return Objects.equals(use, air.use);
    }
}
*/
