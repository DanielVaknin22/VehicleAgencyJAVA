package vehicle;

import javax.swing.*;
/**
 * The GameGlider class represents a toy air vehicle, non-motorized for civil use and have an energy score.
 */
public class Game extends Vehicle implements noMotorized, IAir{
    private String power;
    private energyScore energy;
    private String use;
    /**
     * Constructs a new Game object with default values for model, maximum of passengers, maximum speed, power source and energy score.
     */
    public Game(ImageIcon img) {
        super("toy", 0, 10,img);
        this.use = "civil";
        this.energy = energyScore.A;
        this.power = "manual";
    }

    /**
     * Sets the power source for the Game object.
     * @param power The power source for the Game object.
     */
    @Override
    public void setPowerSource(String power) {
        this.power = power;
    }

    /**
    * Sets the energy score for the Game object.
    * @param energy The energy score for the Game object.
    */
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

    /**
     *  toString method to represent a GameGlider object.
     * @return a string representation of the GameGlider object.
     */
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
        Game game = (Game) o;
        return power.equals(game.power) && energy == game.energy && use.equals(game.use);
    }

    /**
     * Compares the Game object to another object to determine if they are equal.
     * @param o The object to compare to.
     * @return true if the objects are equal, false otherwise.
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


