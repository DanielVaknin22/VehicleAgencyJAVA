package vehicle;

import java.util.Objects;

public class Frigate extends Marine implements Motorized{
    private float fuel;
    private float life;
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

    @Override
    public String toString() {
        return super.toString() +
                ". The average fuel is: " + fuel +
                " The average life is: " + life + ".";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Frigate frigate = (Frigate) o;
        return Float.compare(frigate.fuel, fuel) == 0 && Float.compare(frigate.life, life) == 0;
    }
}
