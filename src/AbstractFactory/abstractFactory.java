package AbstractFactory;

import javax.swing.*;

public interface abstractFactory<T> {
    T create(String vehicleType, String model, int maxSpeed, int maxPassengers, ImageIcon image);
}

