package Decorators;

import vehicle.IVehicle;

import javax.swing.border.Border;

public abstract class VehicleDecorator implements IVehicle {
    private IVehicle vehicle;
    public VehicleDecorator(IVehicle v) {
        vehicle=v;
    }
    @Override
    public String getColor() {
        return vehicle.getColor();
    }
    @Override
    public Border getBorder() {
        return vehicle.getBorder();
    }

    @Override
    public String getStatus() {
        return vehicle.getStatus();
    }

    @Override
    public String toString()
    {
        return vehicle.toString();
    }
}
