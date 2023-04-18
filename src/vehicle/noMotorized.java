package vehicle;
enum energyScore{
    A,
    B,
    C
}

public interface noMotorized {
    public void setPowerSource(String power);
    public void setEnergyScore(energyScore energy);
    public String getPowerSource();
    public energyScore getEnergyScore();
}
