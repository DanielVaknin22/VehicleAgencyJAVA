package vehicle;

import java.util.Objects;

public class Spy extends Air implements noMotorized{
    private String power;
    private energyScore energy;
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
        return super.toString() +
                ". The power source is: " + power +
                " The energy score is: " + energy + ".";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Spy spy = (Spy) o;
        return Objects.equals(power, spy.power) && energy == spy.energy;
    }
}
