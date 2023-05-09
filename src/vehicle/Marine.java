/*
package vehicle;
*/
/**
 The Marine class is an abstract class that represents a type of vehicle that can travel on water.
 It extends the Vehicle class and adds the fields for wind direction and flag.
 *//*

import java.util.Objects;

public abstract class Marine extends Vehicle {
    protected boolean withWind;
    protected String flag;

    */
/**
     Constructor for the Marine class that takes in model, maxPassengers, maxSpeed, wind direction and flag parameters.
     @param model - the model of the marine vehicle.
     @param maxPassengers - the maximum number of passengers the marine vehicle can carry.
     @param maxSpeed - the maximum speed the marine vehicle can travel at.
     @param withWind - a boolean value indicating if the marine vehicle Sail with the wind direction or not.
     @param flag - the country flag of the vehicle.
     *//*

    public Marine(String model, int maxPassengers, int maxSpeed, boolean withWind, String flag) {
        super(model, maxPassengers, maxSpeed);
        this.flag = flag;
        this.withWind = withWind;
    }

    public boolean isWithWind() {
        return withWind;
    }

    public void setWithWind(boolean withWind) {
        this.withWind = withWind;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        String wind = withWind? " with": " without";
        return super.toString() +
                " Under " + flag + " flag, " + wind + " the wind.";
    }

    */
/**
     Determines if this Marine object is equal to another Marine object by comparing the fields.
     @param o - the object to compare with.
     @return a boolean value indicating if the objects are equal or not.
     *//*

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Marine marine = (Marine) o;
        return withWind == marine.withWind && Objects.equals(flag, marine.flag);
    }
}
*/
