package AbstractFactory;

import vehicle.*;
import javax.swing.*;
import java.awt.*;

public class VehicleFactory implements abstractFactory<Vehicle> {

    @Override
    public Vehicle create(String vehicleType, String model, int maxSpeed, int maxPassengers, ImageIcon image, Color color) {
        if ("Jeep".equals(vehicleType)) {
            return new Jeep(model, maxSpeed,0, 0, image, color);
        } else if ("Frigate".equals(vehicleType)) {
            return new Frigate(model, maxPassengers, maxSpeed, false, image, color);
        } else if ("Game".equals(vehicleType)) {
            return new Game(image, color);
        } else if ("Spy".equals(vehicleType)) {
            return new Spy(null, image, color);
        } else if ("Bicycle".equals(vehicleType)) {
            return new Bicycle(model, maxPassengers, maxSpeed, "default", image, color);
        } else if ("CruiseShip".equals(vehicleType)) {
            return new CruiseShip(model, maxPassengers, maxSpeed, "default", 0, 0, image, color);
        } else if ("Amphibious".equals(vehicleType)) {
            return new Amphibious(model, maxPassengers, maxSpeed, 0, "default", false,0,0, image, color);
        } else if ("ElectricBicycle".equals(vehicleType)) {
            return new ElectricBicycle(model, maxPassengers, maxSpeed, "default", 0, image, color);
        } else if ("HybridPlane".equals(vehicleType)) {
            return new HybridPlane(model, maxPassengers, maxSpeed, 0, "default", false , 0, 0, image, color);
        }
        return null;
    }
}