package AbstractFactory;

import vehicle.*;
import javax.swing.*;

public class VehicleFactory implements abstractFactory<Vehicle> {

    @Override
    public Vehicle create(String vehicleType, String model, int maxSpeed, int maxPassengers, ImageIcon image) {
        if ("Jeep".equals(vehicleType)) {
            return new Jeep(model, maxSpeed,0, 0, image);
        } else if ("Frigate".equals(vehicleType)) {
            return new Frigate(model, maxPassengers, maxSpeed, false, image);
        } else if ("Game".equals(vehicleType)) {
            return new Game(image);
        } else if ("Spy".equals(vehicleType)) {
            return new Spy(null, image);
        } else if ("Bicycle".equals(vehicleType)) {
            return new Bicycle(model, maxPassengers, maxSpeed, "default", image);
        } else if ("CruiseShip".equals(vehicleType)) {
            return new CruiseShip(model, maxPassengers, maxSpeed, "default", 0, 0, image);
        } else if ("Amphibious".equals(vehicleType)) {
            return new Amphibious(model, maxPassengers, maxSpeed, 0, "default", false,0,0, image);
        } else if ("ElectricBicycle".equals(vehicleType)) {
            return new ElectricBicycle(model, maxPassengers, maxSpeed, "default", 0, image);
        } else if ("HybridPlane".equals(vehicleType)) {
            return new HybridPlane(model, maxPassengers, maxSpeed, 0, "default", false , 0, 0, image);
        }
        return null;
    }
}