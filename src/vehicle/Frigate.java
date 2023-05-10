package vehicle;

/**

 The Frigate class represents a type of marine vehicle that is motorized.
 It includes methods for setting and getting the average fuel consumption and life expectancy of the frigate.
 It extends the SeaTransportation class and implements the Motorized interface.
 */
import javax.swing.*;
import java.util.Objects;

public class Frigate extends Vehicle implements Motorized, IMarine{
    private float fuel;
    private float life;
    private boolean withWind;
    private String flag;
    /**
     * Constructs a new Frigate object with the specified model, maximum number of passengers, maximum speed, and country.
     * The fuel and life are set to default values of 500 and 4, respectively.
     *
     * @param model the model of the frigate
     * @param maxPassengers the maximum number of passengers the frigate can carry
     * @param maxSpeed the maximum speed of the frigate
     * @param withWind a boolean indicating whether or not the frigate can sail with the wind
     */
    public Frigate(String model, int maxPassengers, int maxSpeed, boolean withWind, ImageIcon img) {
        super(model, maxPassengers, maxSpeed, img);
        this.withWind = withWind;
        this.flag = "Israel";
        this.fuel = 500;
        this.life = 4;
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
    /**
     * toString method for Frigate objects.
     * @return a string representation of the Frigate object
     */
    @Override
    public String toString() {
        String wind = withWind? "with": "without";
        return this.getClass().getSimpleName() + ": " + super.toString() +
                " Under " + flag + " flag, " + wind + " the wind." +
                " The average fuel is: " + fuel +
                " The average life is: " + life + ".";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Frigate frigate = (Frigate) o;
        return Float.compare(frigate.fuel, fuel) == 0 && Float.compare(frigate.life, life) == 0 && withWind == frigate.withWind && flag.equals(frigate.flag);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fuel, life, withWind, flag);
    }

    /**
     * Determines whether a frigate object is equal to another frigate object by comparing all data members.
     * @param o the object to compare to this object
     * @return true if the objects are equal in all data members, false otherwise
     */


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
}
