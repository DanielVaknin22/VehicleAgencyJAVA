package vehicle;

/**
 * The Jeep class represents a type of motorized, commercial land vehicle.
 * It extends the Land class and implements the Motorized and Commercial interfaces.
 */
import java.util.Objects;

public class Jeep extends Vehicle implements Motorized, Commercial, ILand{
    private float fuel;
    private float life;
    private licenseType license;
    private int wheels;
    private String roadType;

    /**
     * Constructs a new Jeep object with the given model, maximum speed, average fuel consumption, and average lifespan.
     * @param model The model of the Jeep.
     * @param maxSpeed The maximum speed of the Jeep in kilometers per hour.
     * @param fuel The average fuel consumption of the Jeep in liters per 100 kilometers..
     * @param life The average lifespan of the Jeep in years.
     */
    public Jeep(String model, int maxSpeed, float fuel, float life) {
        super(model, 5, maxSpeed);
        this.wheels = 4;
        this.roadType = "dirt";
        this.fuel = fuel;
        this.life = life;
        this.license = licenseType.MINI;
    }

    /**
     * Sets the average fuel consumption of the Jeep.
     * @param fuel The average fuel consumption.
     */
    @Override
    public void setAverageFuel(float fuel) {
        this.fuel = fuel;
    }

    /**
     * Sets the average lifespan of the Jeep.
     * @param life The average lifespan.
     */
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
     * Sets the license type required to operate the Jeep.
     * @param license The required license type.
     */
    @Override
    public void setLicenseType(licenseType license) {
        this.license = license;
    }

    @Override
    public licenseType getLicenseType() {
        return license;
    }

    /**
     *  toString method to represent a Jeep object.
     * @return A string representation of the Jeep object.
     */
    @Override
    public String toString() {
        return this.getClass().getSimpleName() + ": "+ super.toString() +
                ". The average fuel is: " + fuel +
                " The average life is: " + life +
                ". The license type is: " + license + ".";
    }

    /**
     * Compares this Jeep object to the specified object for equality.
     * Returns true if and only if the specified object is also a Jeep object and both objects have the same properties.
     * @param o The object to compare to.
     * @return True if the objects are equal, false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Jeep jeep = (Jeep) o;
        return Float.compare(jeep.fuel, fuel) == 0 && Float.compare(jeep.life, life) == 0 && license == jeep.license;
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
}
