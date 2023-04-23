package vehicle;
/**
 * The Motorized interface represents a type of vehicle that is powered by a motor, and provides methods for setting and
 * getting the average fuel consumption and average lifespan of the vehicle.
 */
public interface Motorized {

    /**
     * Sets the average fuel consumption of the motorized vehicle.
     * @param fuel The average fuel consumption to set in liters per 100 kilometers.
     */
    public void setAverageFuel(float fuel);

    /**
     * Sets the average lifespan of the motorized vehicle.
     * @param life The average lifespan to set in liters per 100 kilomete.
     */
    public void setAverageLife(float life);

    /**
     * Sets the average fuel consumption of the motorized vehicle.
     * @return The average fuel consumption of the motorized vehicle in years.
     */
    public float getAverageFuel();

    /**
     * Returns the average lifespan of the motorized vehicle.
     * @return The average lifespan of the motorized vehicle.
     */
    public float getAverageLife();
}
