package vehicle;
/**
 * The Spy class represents a military Aerial vehicle, non-motorized for military use and have an energy score.
 */
import java.util.Objects;

public class Spy extends Air implements noMotorized{
    private String power;
    private energyScore energy;
    /**
     * Constructs a Spy object with the given model, maximum number of passengers, maximum speed,
     * and energy score. all data members is by default.
     * @param power the source of power of the Spy.
     */
    public Spy(String power) {
        super("private" ,1 , 50, "military");
        this.energy = energyScore.C;
        this.power = power;
    }

    @Override
    public void setPowerSource(String power) {
        this.power = power;
    }

    @Override
    public void setEnergyScore(energyScore energy) {
        this.energy = energy;
    }

    @Override
    public String getPowerSource() {
        return power;
    }

    @Override
    public energyScore getEnergyScore() {
        return energy;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + ": " + super.toString() +
                ". The power source is: " + power +
                " The energy score is: " + energy + ".";
    }

    /**
     * Checks if the spy vehicle is equal to another object.
     * @param o the object to compare to
     * @return true if the spy vehicle is equal to the object, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Spy spy = (Spy) o;
        return Objects.equals(power, spy.power) && energy == spy.energy;
    }
}
