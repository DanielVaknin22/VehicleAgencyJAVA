package vehicle;

import java.util.Objects;

public class Jeep extends Land implements Motorized, Commercial{
    private float fuel;
    private float life;
    private licenseType license;
    public Jeep(String model, int maxSpeed, float fuel, float life) {
        super(model, 5, maxSpeed, 4, "dirt");
        this.fuel = fuel;
        this.life = life;
        this.license = licenseType.MINI;
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

    @Override
    public void setLicenseType(licenseType license) {
        this.license = license;
    }

    @Override
    public licenseType getLicenseType() {
        return license;
    }

    @Override
    public String toString() {
        return super.toString() +
                ". The average fuel is: " + fuel +
                " The average life is: " + life +
                ". The license type is: " + license + ".";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Jeep jeep = (Jeep) o;
        return Float.compare(jeep.fuel, fuel) == 0 && Float.compare(jeep.life, life) == 0 && license == jeep.license;
    }
}
