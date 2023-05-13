package vehicle;

import javax.swing.*;

public class CruiseShip extends Vehicle implements IMarine, Motorized, Commercial{
    private boolean withWind;
    private String flag;
    private float fuel;
    private float life;
    private licenseType license;

    /**
     * Constructs a new CruiseShip object with the given model, maximum number of passengers, maximum speed,
     * flag, fuel, life, and image.
     * @param model the model of the cruise ship
     * @param maxPassengers the maximum number of passengers the cruise ship can carry
     * @param maxSpeed the maximum speed of the cruise ship
     * @param flag the flag representing the cruise ship's nationality
     * @param fuel the average fuel consumption of the cruise ship
     * @param life the average life expectancy of the cruise ship
     * @param img the image representing the cruise ship
     */
    public CruiseShip(String model, int maxPassengers, int maxSpeed, String flag, float fuel, float life, ImageIcon img) {
        super(model, maxPassengers, maxSpeed, img);
        this.withWind = true;
        this.flag = flag;
        this.fuel = fuel;
        this.life = life;
        this.license = licenseType.UNLIMIT;
    }

    @Override
    public void setLicenseType(licenseType license) {this.license = license; }

    @Override
    public licenseType getLicenseType() {return license; }

    @Override
    public boolean isWithWind() {return withWind; }

    @Override
    public void setWithWind(boolean withWind) {this.withWind = withWind; }
    @Override
    public String getFlag() {return flag; }

    @Override
    public void setFlag(String flag) {this.flag = flag; }

    @Override
    public void setAverageFuel(float fuel) {this.fuel = fuel; }

    @Override
    public void setAverageLife(float life) {this.life = life; }

    @Override
    public float getAverageFuel() {return fuel; }

    @Override
    public float getAverageLife() {return life; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        CruiseShip cruiseShip = (CruiseShip) o;
        return withWind == cruiseShip.withWind && Float.compare(cruiseShip.fuel, fuel) == 0 && Float.compare(cruiseShip.life, life) == 0 && flag.equals(cruiseShip.flag) && license == cruiseShip.license;
    }

    /**
     *  toString method to represent a Cruise Ship object.
     * @return a string representation of the Cruise Ship object.
     */
    @Override
    public String toString() {
        String wind = withWind? " with": " without";
        return this.getClass().getSimpleName() + ": " + super.toString() +
                " Under " + flag + " flag, " + wind + " the wind." +
                " The license type is: " + license +
                ". The average fuel is: " + fuel +
                " The average life is: " + life + ".";
    }
}
