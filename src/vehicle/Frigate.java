package vehicle;

/**

 The Frigate class represents a type of marine vehicle that is motorized.
 It includes methods for setting and getting the average fuel consumption and life expectancy of the frigate.
 It extends the SeaTransportation class and implements the Motorized interface.
 */
import java.util.Objects;

public class Frigate extends Marine implements Motorized{
    private float fuel;
    private float life;

    /**
     * Constructs a new Frigate object with the specified model, maximum number of passengers, maximum speed, and country.
     * The fuel and life are set to default values of 500 and 4, respectively.
     *
     * @param model the model of the frigate
     * @param maxPassengers the maximum number of passengers the frigate can carry
     * @param maxSpeed the maximum speed of the frigate
     * @param withWind a boolean indicating whether or not the frigate can sail with the wind
     */
    public Frigate(String model, int maxPassengers, int maxSpeed, boolean withWind) {
        super(model, maxPassengers, maxSpeed, withWind, "Israel");
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
        return this.getClass().getSimpleName() + ": " + super.toString() +
                ". The average fuel is: " + fuel +
                " The average life is: " + life + ".";
    }
    /**
     * Determines whether a frigate object is equal to another frigate object by comparing all data members.
     * @param o the object to compare to this object
     * @return true if the objects are equal in all data members, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Frigate frigate = (Frigate) o;
        return Float.compare(frigate.fuel, fuel) == 0 && Float.compare(frigate.life, life) == 0;
    }
}
