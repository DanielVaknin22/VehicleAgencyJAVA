package vehicle;
/**
 * This interface represents a non-motorized vehicle.
 * It provides methods for setting and getting the power source and energy score of the vehicle.
 */
enum energyScore{
    /**
     * Energy score A.
     */
    A,
    /**
     * Energy score B.
     */
    B,
    /**
     * Energy score C.
     */
    C
}

public interface noMotorized {

    /**
     * Sets the power source of the non-motorized vehicle.
     * @param power a string representing the power source
     */
    public void setPowerSource(String power);

    /**
     * Sets the energy score of the non-motorized vehicle.
     * @param energy an energyScore enum representing the energy efficiency rating of the vehicle.
     */
    public void setEnergyScore(energyScore energy);

    /**
     * Gets the power source of the non-motorized vehicle.
     * @return a string representing the power source
     */
    public String getPowerSource();

    /**
     * Gets the energy score of the non-motorized vehicle.
     * @return an energyScore enum representing the energy efficiency rating of the vehicle.
     */
    public energyScore getEnergyScore();
}
