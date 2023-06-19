package Decorators;

import vehicle.IVehicle;

import javax.swing.border.Border;

public class statusDecorator extends VehicleDecorator{
    private IVehicle vehicle;
    private String status;

    public statusDecorator(IVehicle vehicle,String status) {
        super(vehicle);
        this.vehicle=vehicle;
        this.status=status;
    }

    @Override
    public Border getBorder() {
        return vehicle.getBorder();
    }

    public void setStatus(String newStatus) {
        status = newStatus;
    }

    @Override
    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return super.toString() + " ,Status: " + status;
    }
}
