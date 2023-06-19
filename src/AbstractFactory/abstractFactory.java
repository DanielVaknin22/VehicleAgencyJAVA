package AbstractFactory;

import javax.swing.*;
import java.awt.*;

public interface abstractFactory<T> {
    T create(String vehicleType, String model, int maxSpeed, int maxPassengers, ImageIcon image, Color color);
}

