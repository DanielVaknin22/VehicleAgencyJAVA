package Decorators;

import vehicle.IVehicle;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class colorDecorator extends VehicleDecorator {
    private String color;
    private IVehicle vehicle;

    public colorDecorator(String color, IVehicle vehicle) {
        super(vehicle);
        this.color = color;
        this.vehicle = vehicle;
    }

    @Override
    public String getColor() {
        return color;
    }


    @Override
    public Border getBorder() {
        switch (color) {
            case "Black":
                return BorderFactory.createLineBorder(Color.BLACK, 5);
            case "Red":
                return BorderFactory.createLineBorder(Color.RED, 5);
            case "Yellow":
                return BorderFactory.createLineBorder(Color.YELLOW, 5);
            case "Blue":
                return BorderFactory.createLineBorder(Color.BLUE, 5);
            case "Purple":
                return BorderFactory.createLineBorder(Color.MAGENTA, 5);
            case "Gray":
                return BorderFactory.createLineBorder(Color.GRAY, 5);
            case "Green":
                return BorderFactory.createLineBorder(Color.GREEN, 5);
            case "White":
                return BorderFactory.createLineBorder(Color.WHITE, 5);
            default: // Pink
                return BorderFactory.createLineBorder(Color.PINK, 5);        }
    }
}
