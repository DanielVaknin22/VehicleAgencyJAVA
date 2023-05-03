package vehicle;

public class Bicycle extends Vehicle implements noMotorized, ILand{

    private String power;
    private energyScore energy;
    private int wheels;
    private String roadType;

    /**
     * Constructs a new Vehicle object with the given model, maximum number of passengers, and maximum speed.
     *
     * @param model         the model of the vehicle
     * @param maxPassengers the maximum number of passengers the vehicle can carry
     * @param maxSpeed      the maximum speed of the vehicle
     */
    public Bicycle(String model, int maxPassengers, int maxSpeed, String roadType) {
        super(model, maxPassengers, maxSpeed);
        this.energy = energyScore.A;
        this.power = "manual";
        this.wheels = 2;
    }

    @Override
    public int getWheels() {
        return wheels;
    }

    @Override
    public void setWheels(int wheels) {
        this.wheels = wheels;
    }

    @Override
    public String getRoadType() {
        return roadType;
    }

    @Override
    public void setRoadType(String roadType) {
        this.roadType = roadType;
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
}
