package vehicle;

import java.util.Objects;

public class Game extends Air implements noMotorized{
    private String power;
    private energyScore energy;
    public Game() {
        super("toy", 0, 10, "civil");
        this.energy = energyScore.A;
        this.power = "manual";
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
        return super.toString() +
                ". The power source is: " + power +
                " The energy score is: " + energy + ".";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Game game = (Game) o;
        return Objects.equals(power, game.power) && energy == game.energy;
    }
}


