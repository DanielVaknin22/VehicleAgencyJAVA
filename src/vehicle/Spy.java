package vehicle;
/**
 * The Spy class represents a military Aerial vehicle, non-motorized for military use and have an energy score.
 */

import javax.swing.*;

public class Spy extends Vehicle implements noMotorized, IAir{
    private String power;
    private energyScore energy;
    private String use;
    /**
     * Constructs a Spy object with the given model, maximum number of passengers, maximum speed,
     * and energy score. all data members is by default.
     * @param power the source of power of the Spy.
     * @param img The img of the Spy.
     */
    public Spy(String power, ImageIcon img) {
        super("private" ,1 , 50,img);
        this.use = "military";
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
                " It is used for: " + use +
                ". The power source is: " + power +
                " The energy score is: " + energy + ".";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Spy spy = (Spy) o;
        return power.equals(spy.power) && energy == spy.energy && use.equals(spy.use);
    }

    /**
     * Checks if the spy vehicle is equal to another object.
     * @param o the object to compare to
     * @return true if the spy vehicle is equal to the object, false otherwise
     */


    @Override
    public String getUse() {
        return use;
    }

    @Override
    public void setUse(String use) {
        this.use = use;
    }
}
