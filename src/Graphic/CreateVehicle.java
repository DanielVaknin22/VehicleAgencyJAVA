package Graphic;

import AbstractFactory.VehicleFactory;
import vehicle.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import vehicle.Vehicle;
import java.util.ArrayList;

/**
 * Represents a dialog window for creating a vehicle.
 */
public class CreateVehicle extends JFrame implements ActionListener {
    private static JButton[] ArrJButton = new JButton[10];
    private MenuFrame mainWindow;
    private VehicleFactory vehicleFactory = new VehicleFactory();

    public CreateVehicle(MenuFrame windows, ArrayList<Vehicle> vehicles) {
        super("Create Vehicle");
        //this.vehicles = vehicle;
        //vehicles = vehicle;
        mainWindow = windows;
        JPanel createPanel = new JPanel();
        createPanel.setLayout(null);
        this.InitButtons();
        createPanel.setBounds(15, 0, 600, 300);
        JLabel Choose = new JLabel("Choose type of car");
        Choose.setFont(new Font(Choose.getName(),Font.BOLD, 30));
        Choose.setBounds(140, -20, 400, 150);
        createPanel.add(Choose);
        for (JButton jButton : ArrJButton) {
            createPanel.add(jButton);
            jButton.addActionListener(this);
        }
        ImageIcon icon = new ImageIcon("Pictures\\Menu.png");
        Image im = icon.getImage();
        Image scaledIm = im.getScaledInstance(600, 350, 4);
        ImageIcon img = new ImageIcon(scaledIm);
        JLabel LogoLabel = new JLabel();
        LogoLabel.setBounds(0, 300, 600, 400);
        LogoLabel.setIcon(img);
        createPanel.add(LogoLabel);
        this.setBounds(0, 30, 600, 730);
        this.setLocationRelativeTo(null);
        this.SetImageAndPlaceText();
        add(createPanel);
        this.setVisible(true);

    }

    public ArrayList<Vehicle> getVehicles() {
        return new ArrayList<>(MenuFrame.vehicles);
    }

    private ImageIcon getImageFromUser() {
        ImageIcon imageIcon = null;
        JFileChooser fileChooser = new JFileChooser();
        String[] button = {"Set by default", "Upload an image"};
        int option = JOptionPane.showOptionDialog(this, "Select Your option please",
                "Set the image for the vehicle", JOptionPane.DEFAULT_OPTION,JOptionPane.QUESTION_MESSAGE,
                null,button, button[0]);
        if (option == 1 ) {
            int result = fileChooser.showOpenDialog(this);
            do {
                if (result == JFileChooser.CANCEL_OPTION) {
                    JOptionPane.showMessageDialog(this,
                            "You must select an image file", "Select Image", JOptionPane.ERROR_MESSAGE);
                    result = fileChooser.showOpenDialog(this);
                }
            } while (result == JFileChooser.CANCEL_OPTION);
            if (result == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                try {
                    imageIcon = new ImageIcon(Files.readAllBytes(selectedFile.toPath()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (imageIcon != null) {
                imageIcon = new ImageIcon(imageIcon.getImage().getScaledInstance(180, 170, Image.SCALE_DEFAULT));
            }
        }
        if(imageIcon == null) JOptionPane.showMessageDialog(this, "The image will be setting by default");
        return imageIcon;
    }

    public void addVehicle(Vehicle newVehicle) {
        if (newVehicle != null) {
            MenuFrame.vehicles.add(newVehicle);
            dispose(); // Close the CreateVehicle frame
        }
    }

    /**
     * Initializes the buttons for vehicle types.
     */
    public void InitButtons() {
        String[] nameArray = new String[]{"Jeep", "Frigate", "Spy", "Game", "Amphibious", "Bicycle", "CruiseShip", "ElectricBicycle", "HybridPlane", "Menu"};
        int x = 20, y = 100;

        for(int i = 0; i < ArrJButton.length; ++i) {
            ArrJButton[i] = new JButton(nameArray[i]);
            if (i == ArrJButton.length / 2) {
                y = 210;
                x = 20;
            }

            ArrJButton[i].setBounds(x, y, 105, 100);
            x += 110;
        }
    }

    /**
     * Sets images and places text for the buttons.
     */
    public void SetImageAndPlaceText() {
        String[] sourceImg = new String[]{"Pictures\\JeepIcon.png", "Pictures\\FrigateIcon.png", "Pictures\\SpyIcon.png", "Pictures\\GameIcon.png", "Pictures\\AmphibiousIcon.png", "Pictures\\BicycleIcon.png", "Pictures\\CruiseShipIcon.png", "Pictures\\ElectricBicycleIcon.png", "Pictures\\HybridPlaneIcon.png", "Pictures\\MenuIcon.png"};
        for(int i = 0; i < ArrJButton.length; ++i) {
            ImageIcon icon = new ImageIcon(sourceImg[i]);
            Image im = icon.getImage();
            Image scaledIm = im.getScaledInstance(95, 80, 4);
            ImageIcon img = new ImageIcon(scaledIm);
            ArrJButton[i].setIcon(img);
            ArrJButton[i].setHorizontalTextPosition(0);
            ArrJButton[i].setVerticalTextPosition(1);
        }
    }

    /**
     * Creates a Jeep object based on user input.
     * @return The created Jeep object or null if the user cancels the operation.
     */
    private Jeep createJeep() {
        String[] color = new String[]{"Grey", "Red", "White", "Blue"};
        ImageIcon img = getImageFromUser();
        String option = "";
        if (img == null) {
            option = (String) JOptionPane.showInputDialog(this, "Choose the color of the Jeep: ", "Color", JOptionPane.PLAIN_MESSAGE, null, color, color[0]);
        }
        String model;
        while (true) {
            model = JOptionPane.showInputDialog(this, "Enter Model: ");
            if (model == null || model.isEmpty()) {
                int optionResult = JOptionPane.showConfirmDialog(this, "Please enter a value for Model.", "Missing Field", JOptionPane.OK_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE);
                if (optionResult == JOptionPane.CANCEL_OPTION) {
                    return null; // User clicked cancel, exit method
                }
            } else if (!model.matches("[a-zA-Z]+")) {
                JOptionPane.showMessageDialog(this, "Invalid input. Model should only contain letters.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
            } else {
                break; // Break out of the loop if a valid value is entered
            }
        }
        int maxSpeed;
        while (true) {
            String maxSpeedStr = JOptionPane.showInputDialog(this, "Enter Max Speed: ");
            if (maxSpeedStr == null || maxSpeedStr.isEmpty()) {
                int optionResult = JOptionPane.showConfirmDialog(this, "Please enter a value for Max Speed.", "Missing Field", JOptionPane.OK_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE);
                if (optionResult == JOptionPane.CANCEL_OPTION) {
                    return null; // User clicked cancel, exit method
                }
            } else {
                try {
                    maxSpeed = Integer.parseInt(maxSpeedStr);
                    break; // Break out of the loop if a valid integer value is entered
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(this, "Invalid input. Max Speed should be an integer.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        float avFuel;
        while (true) {
            String avFuelStr = JOptionPane.showInputDialog(this, "Enter Average Fuel: ");
            if (avFuelStr == null || avFuelStr.isEmpty()) {
                int optionResult = JOptionPane.showConfirmDialog(this, "Please enter a value for Average Fuel.", "Missing Field", JOptionPane.OK_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE);
                if (optionResult == JOptionPane.CANCEL_OPTION) {
                    return null; // User clicked cancel, exit method
                }
            } else {
                try {
                    avFuel = Float.parseFloat(avFuelStr);
                    break; // Break out of the loop if a valid float value is entered
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(this, "Invalid input. Average Fuel should be a floating-point number.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        float avLife;
        while (true) {
            String avLifeStr = JOptionPane.showInputDialog(this, "Enter Average Life: ");
            if (avLifeStr == null || avLifeStr.isEmpty()) {
                int optionResult = JOptionPane.showConfirmDialog(this, "Please enter a value for Average Life.", "Missing Field", JOptionPane.OK_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE);
                if (optionResult == JOptionPane.CANCEL_OPTION) {
                    return null; // User clicked cancel, exit method
                }
            } else {
                try {
                    avLife = Float.parseFloat(avLifeStr);
                    break; // Break out of the loop if a valid float value is entered
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(this, "Invalid input. Average Life should be a floating-point number.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
                }
            }
        }

        switch (option) {
            case "Grey":
                img = new ImageIcon("Pictures\\jeep1.png");
                break;
            case "Red":
                img = new ImageIcon("Pictures\\jeep2.png");
                break;
            case "White":
                img = new ImageIcon("Pictures\\jeep3.png");
                break;
            case "Blue":
                img = new ImageIcon("Pictures\\jeep4.png");
                break;
        }
        Jeep jeep = (Jeep) vehicleFactory.create("Jeep", model, maxSpeed,0,img);
        jeep.setAverageFuel(avFuel);
        jeep.setAverageLife(avLife);
        return jeep;
    }



    /**
     * Creates a Frigate object based on user input.
     * @return The created Frigate object or null if the user cancels the operation.
     */
    private Frigate createFrigate() {
        String[] color = new String[]{"Grey", "White", "Green"};
        ImageIcon img = getImageFromUser();
        String option = "";
        if (img == null) {
            option = (String) JOptionPane.showInputDialog(this, "Choose the color of the Frigate: ", "color", 3, (Icon) null, color, color[0]);
        }
        String model;
        while (true) {
            model = JOptionPane.showInputDialog(this, "Enter Model: ");
            if (model == null || model.isEmpty()) {
                int optionResult = JOptionPane.showConfirmDialog(this, "Please enter a value for Model.", "Missing Field", JOptionPane.OK_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE);
                if (optionResult == JOptionPane.CANCEL_OPTION) {
                    return null; // User clicked cancel, exit method
                }
            } else if (!model.matches("[a-zA-Z]+")) {
                JOptionPane.showMessageDialog(this, "Invalid input. Model should only contain letters.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
            } else {
                break; // Break out of the loop if a valid value is entered
            }
        }
        int maxPassengers;
        while (true) {
            String maxPassengersStr = JOptionPane.showInputDialog(this, "Enter Max Passengers: ");
            if (maxPassengersStr == null || maxPassengersStr.isEmpty()) {
                int optionResult = JOptionPane.showConfirmDialog(this, "Please enter a value for Max Passengers.", "Missing Field", JOptionPane.OK_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE);
                if (optionResult == JOptionPane.CANCEL_OPTION) {
                    return null; // User clicked cancel, exit method
                }
            } else {
                try {
                    maxPassengers = Integer.parseInt(maxPassengersStr);
                    break; // Break out of the loop if a valid value is entered
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(this, "Invalid input. Please enter a valid integer for Max Passengers.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        int maxSpeed;
        while (true) {
            String maxSpeedStr = JOptionPane.showInputDialog(this, "Enter Max Speed: ");
            if (maxSpeedStr == null || maxSpeedStr.isEmpty()) {
                int optionResult = JOptionPane.showConfirmDialog(this, "Please enter a value for Max Speed.", "Missing Field", JOptionPane.OK_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE);
                if (optionResult == JOptionPane.CANCEL_OPTION) {
                    return null; // User clicked cancel, exit method
                }
            } else {
                try {
                    maxSpeed = Integer.parseInt(maxSpeedStr);
                    break; // Break out of the loop if a valid integer value is entered
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(this, "Invalid input. Max Speed should be an integer.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        boolean witheWind = this.windDirection();
        switch (option) {
            case "Grey":
                img = new ImageIcon("Pictures\\Frigate2.png");
                break;
            case "White":
                img = new ImageIcon("Pictures\\Frigate1.png");
                break;
            case "Green":
                img = new ImageIcon("Pictures\\Frigate3.png");
                break;
        }
        Frigate frigate = (Frigate) vehicleFactory.create("Frigate", model, maxSpeed, maxPassengers, img);
        frigate.setWithWind(witheWind);
        return frigate;
    }

    private boolean windDirection() {
        JPanel wind = new JPanel();
        wind.setLayout(new BoxLayout(wind, 3));
        JRadioButton withWindButton = new JRadioButton("With the wind direction");
        JRadioButton againstWindButton = new JRadioButton("Against the wind direction");
        ButtonGroup windGroup = new ButtonGroup();
        windGroup.add(withWindButton);
        windGroup.add(againstWindButton);
        wind.add(withWindButton);
        wind.add(againstWindButton);
        JOptionPane.showConfirmDialog(this, wind, "Please enter the wind direction:", 2);
        return withWindButton.isSelected();
    }

    /**
     * Creates a Game object based on user input.
     * @return The created Game object or null if the user cancels the operation.
     */
    private Game createGame() {
        String[] color = new String[]{"Blue", "Red", "Green", "Grey"};
        ImageIcon img = getImageFromUser();
        String option = "";
        if (img == null){
            option = (String)JOptionPane.showInputDialog(this, "Choose the color of the Game: ", "color", 3, (Icon)null, color, color[0]);
        }
        switch (option) {
            case "Blue":
                img = new ImageIcon("Pictures\\Game1.png");
                break;
            case "Red":
                img = new ImageIcon("Pictures\\Game2.png");
                break;
            case "Green":
                img = new ImageIcon("Pictures\\Game3.png");
                break;
            case "Grey":
                img = new ImageIcon("Pictures\\Game4.png");
                break;
        }
        Game game = (Game) vehicleFactory.create("Game", null, 0,0, img);
        return game;
    }

    /**
     * Creates a Spy object based on user input.
     * @return The created Spy object or null if the user cancels the operation.
     */
    private Spy createSpy() {
        String[] color = new String[]{"Black", "White"};
        ImageIcon img = getImageFromUser();
        String option = "";
        if (img == null){
            option = (String)JOptionPane.showInputDialog(this, "Choose the color of the Spy: ", "color", 3, (Icon)null, color, color[0]);
        }
        String power;
        while (true) {
            power = JOptionPane.showInputDialog(this, "Enter Power: ");
            if (power == null || power.isEmpty()) {
                int optionResult = JOptionPane.showConfirmDialog(this, "Please enter a value for Power.", "Missing Field", JOptionPane.OK_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE);
                if (optionResult == JOptionPane.CANCEL_OPTION) {
                    return null; // User clicked cancel, exit method
                }
            } else if (!power.matches("[a-zA-Z]+")) {
                JOptionPane.showMessageDialog(this, "Invalid input. Power should only contain letters.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
            } else {
                break; // Break out of the loop if a valid value is entered
            }
        }
        switch (option) {
            case "Black":
                img = new ImageIcon("Pictures\\Spy1.png");
                break;
            case "White":
                img = new ImageIcon("Pictures\\Spy2.png");
                break;
        }
        Spy spy = (Spy) vehicleFactory.create("Spy", null, 0,0,img);
        spy.setPowerSource(power);
        return spy;
    }

    /**
     * Creates a Amphibious object based on user input.
     * @return The created Amphibious object or null if the user cancels the operation.
     */
    private Amphibious createAmphibious() {
        String[] color = new String[]{"Yellow", "Black", "Red", "Military"};
        ImageIcon img = getImageFromUser();
        String option = "";
        if (img == null){
            option = (String)JOptionPane.showInputDialog(this, "Choose the color of the Amphibious: ", "color", 3, (Icon)null, color, color[0]);
        }
        String model;
        while (true) {
            model = JOptionPane.showInputDialog(this, "Enter Model: ");
            if (model == null || model.isEmpty()) {
                int optionResult = JOptionPane.showConfirmDialog(this, "Please enter a value for Model.", "Missing Field", JOptionPane.OK_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE);
                if (optionResult == JOptionPane.CANCEL_OPTION) {
                    return null; // User clicked cancel, exit method
                }
            } else if (!model.matches("[a-zA-Z]+")) {
                JOptionPane.showMessageDialog(this, "Invalid input. Model should only contain letters.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
            } else {
                break; // Break out of the loop if a valid value is entered
            }
        }
        int maxPassengers;
        while (true) {
            String maxPassengersStr = JOptionPane.showInputDialog(this, "Enter Max Passengers: ");
            if (maxPassengersStr == null || maxPassengersStr.isEmpty()) {
                int optionResult = JOptionPane.showConfirmDialog(this, "Please enter a value for Max Passengers.", "Missing Field", JOptionPane.OK_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE);
                if (optionResult == JOptionPane.CANCEL_OPTION) {
                    return null; // User clicked cancel, exit method
                }
            } else {
                try {
                    maxPassengers = Integer.parseInt(maxPassengersStr);
                    break; // Break out of the loop if a valid value is entered
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(this, "Invalid input. Please enter a valid integer for Max Passengers.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        int maxSpeed;
        while (true) {
            String maxSpeedStr = JOptionPane.showInputDialog(this, "Enter Max Speed: ");
            if (maxSpeedStr == null || maxSpeedStr.isEmpty()) {
                int optionResult = JOptionPane.showConfirmDialog(this, "Please enter a value for Max Speed.", "Missing Field", JOptionPane.OK_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE);
                if (optionResult == JOptionPane.CANCEL_OPTION) {
                    return null; // User clicked cancel, exit method
                }
            } else {
                try {
                    maxSpeed = Integer.parseInt(maxSpeedStr);
                    break; // Break out of the loop if a valid integer value is entered
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(this, "Invalid input. Max Speed should be an integer.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        int wheels;
        while (true) {
            String wheelsStr = JOptionPane.showInputDialog(this, "Enter Wheels: ");
            if (wheelsStr == null || wheelsStr.isEmpty()) {
                int optionResult = JOptionPane.showConfirmDialog(this, "Please enter a value for Wheels.", "Missing Field", JOptionPane.OK_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE);
                if (optionResult == JOptionPane.CANCEL_OPTION) {
                    return null; // User clicked cancel, exit method
                }
            } else {
                try {
                    wheels = Integer.parseInt(wheelsStr);
                    break; // Break out of the loop if a valid integer value is entered
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(this, "Invalid input. Wheels should be an integer.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        String flag;
        while (true) {
            flag = JOptionPane.showInputDialog(this, "Enter Flag: ");
            if (flag == null || flag.isEmpty()) {
                int optionResult = JOptionPane.showConfirmDialog(this, "Please enter a value for Flag.", "Missing Field", JOptionPane.OK_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE);
                if (optionResult == JOptionPane.CANCEL_OPTION) {
                    return null; // User clicked cancel, exit method
                }
            } else if (!flag.matches("[a-zA-Z]+")) {
                JOptionPane.showMessageDialog(this, "Invalid input. Flag should only contain letters.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
            } else {
                break; // Break out of the loop if a valid value is entered
            }
        }
        boolean witheWind = this.windDirection();
        float avFuel;
        while (true) {
            String avFuelStr = JOptionPane.showInputDialog(this, "Enter Average Fuel: ");
            if (avFuelStr == null || avFuelStr.isEmpty()) {
                int optionResult = JOptionPane.showConfirmDialog(this, "Please enter a value for Average Fuel.", "Missing Field", JOptionPane.OK_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE);
                if (optionResult == JOptionPane.CANCEL_OPTION) {
                    return null; // User clicked cancel, exit method
                }
            } else {
                try {
                    avFuel = Float.parseFloat(avFuelStr);
                    break; // Break out of the loop if a valid float value is entered
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(this, "Invalid input. Average Fuel should be a floating-point number.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        float avLife;
        while (true) {
            String avLifeStr = JOptionPane.showInputDialog(this, "Enter Average Life ");
            if (avLifeStr == null || avLifeStr.isEmpty()) {
                int optionResult = JOptionPane.showConfirmDialog(this, "Please enter a value for Average Life.", "Missing Field", JOptionPane.OK_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE);
                if (optionResult == JOptionPane.CANCEL_OPTION) {
                    return null; // User clicked cancel, exit method
                }
            } else {
                try {
                    avLife = Float.parseFloat(avLifeStr);
                    break; // Break out of the loop if a valid float value is entered
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(this, "Invalid input. Average Life should be a floating-point number.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        switch (option) {
            case "Yellow":
                img = new ImageIcon("Pictures\\amphibious1.png");
                break;
            case "Black":
                img = new ImageIcon("Pictures\\amphibious2.png");
                break;
            case "Red":
                img = new ImageIcon("Pictures\\amphibious3.png");
                break;
            case "Military":
                img = new ImageIcon("Pictures\\amphibious4.png");
                break;
        }
        Amphibious amphibious = (Amphibious) vehicleFactory.create("Amphibious", model, maxSpeed,maxPassengers,img);
        amphibious.setWheels(wheels);
        amphibious.setFlag(flag);
        amphibious.setWithWind(witheWind);
        amphibious.setAverageFuel(avFuel);
        amphibious.setAverageLife(avLife);
        return amphibious;
    }

    /**
     * Creates a Bicycle object based on user input.
     * @return The created Bicycle object or null if the user cancels the operation.
     */
    private Bicycle createBicycle() {
        String[] color = new String[]{"Red", "Blue", "Purple", "Black"};
        ImageIcon img = getImageFromUser();
        String option = "";
        if (img == null){
            option = (String)JOptionPane.showInputDialog(this, "Choose the color of the Bicycle: ", "color", 3, (Icon)null, color, color[0]);
        }
        String model;
        while (true) {
            model = JOptionPane.showInputDialog(this, "Enter Model: ");
            if (model == null || model.isEmpty()) {
                int optionResult = JOptionPane.showConfirmDialog(this, "Please enter a value for Model.", "Missing Field", JOptionPane.OK_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE);
                if (optionResult == JOptionPane.CANCEL_OPTION) {
                    return null; // User clicked cancel, exit method
                }
            } else if (!model.matches("[a-zA-Z]+")) {
                JOptionPane.showMessageDialog(this, "Invalid input. Model should only contain letters.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
            } else {
                break; // Break out of the loop if a valid value is entered
            }
        }
        int maxPassengers;
        while (true) {
            String maxPassengersStr = JOptionPane.showInputDialog(this, "Enter Max Passengers: ");
            if (maxPassengersStr == null || maxPassengersStr.isEmpty()) {
                int optionResult = JOptionPane.showConfirmDialog(this, "Please enter a value for Max Passengers.", "Missing Field", JOptionPane.OK_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE);
                if (optionResult == JOptionPane.CANCEL_OPTION) {
                    return null; // User clicked cancel, exit method
                }
            } else {
                try {
                    maxPassengers = Integer.parseInt(maxPassengersStr);
                    break; // Break out of the loop if a valid value is entered
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(this, "Invalid input. Please enter a valid integer for Max Passengers.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        int maxSpeed;
        while (true) {
            String maxSpeedStr = JOptionPane.showInputDialog(this, "Enter Max Speed: ");
            if (maxSpeedStr == null || maxSpeedStr.isEmpty()) {
                int optionResult = JOptionPane.showConfirmDialog(this, "Please enter a value for Max Speed.", "Missing Field", JOptionPane.OK_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE);
                if (optionResult == JOptionPane.CANCEL_OPTION) {
                    return null; // User clicked cancel, exit method
                }
            } else {
                try {
                    maxSpeed = Integer.parseInt(maxSpeedStr);
                    break; // Break out of the loop if a valid integer value is entered
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(this, "Invalid input. Max Speed should be an integer.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        String roadType;
        while (true) {
            roadType = JOptionPane.showInputDialog(this, "Enter roadType: ");
            if (roadType == null || roadType.isEmpty()) {
                int optionResult = JOptionPane.showConfirmDialog(this, "Please enter a value for roadType.", "Missing Field", JOptionPane.OK_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE);
                if (optionResult == JOptionPane.CANCEL_OPTION) {
                    return null; // User clicked cancel, exit method
                }
            } else if (!roadType.matches("[a-zA-Z]+")) {
                JOptionPane.showMessageDialog(this, "Invalid input. roadType should only contain letters.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
            } else {
                break; // Break out of the loop if a valid value is entered
            }
        }
        switch (option) {
            case "Red":
                img = new ImageIcon("Pictures\\Bicycle1.png");
                break;
            case "Blue":
                img = new ImageIcon("Pictures\\Bicycle2.png");
                break;
            case "Purple":
                img = new ImageIcon("Pictures\\Bicycle3.png");
                break;
            case "Black":
                img = new ImageIcon("Pictures\\Bicycle4.png");
                break;
        }
        Bicycle bicycle = (Bicycle) vehicleFactory.create("Bicycle", model, maxSpeed,maxPassengers,img);
        bicycle.setRoadType(roadType);
        return bicycle;
    }

    /**
     * Creates a Cruise Ship object based on user input.
     * @return The created Cruise Ship object or null if the user cancels the operation.
     */
    private CruiseShip createCruiseShip() {
        String[] color = new String[]{"Blue", "White"};
        ImageIcon img = getImageFromUser();
        String option = "";
        if (img == null){
            option = (String)JOptionPane.showInputDialog(this, "Choose the color of the Cruise Ship: ", "color", 3, (Icon)null, color, color[0]);
        }
        String model;
        while (true) {
            model = JOptionPane.showInputDialog(this, "Enter Model: ");
            if (model == null || model.isEmpty()) {
                int optionResult = JOptionPane.showConfirmDialog(this, "Please enter a value for Model.", "Missing Field", JOptionPane.OK_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE);
                if (optionResult == JOptionPane.CANCEL_OPTION) {
                    return null; // User clicked cancel, exit method
                }
            } else if (!model.matches("[a-zA-Z]+")) {
                JOptionPane.showMessageDialog(this, "Invalid input. Model should only contain letters.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
            } else {
                break; // Break out of the loop if a valid value is entered
            }
        }
        int maxPassengers;
        while (true) {
            String maxPassengersStr = JOptionPane.showInputDialog(this, "Enter Max Passengers: ");
            if (maxPassengersStr == null || maxPassengersStr.isEmpty()) {
                int optionResult = JOptionPane.showConfirmDialog(this, "Please enter a value for Max Passengers.", "Missing Field", JOptionPane.OK_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE);
                if (optionResult == JOptionPane.CANCEL_OPTION) {
                    return null; // User clicked cancel, exit method
                }
            } else {
                try {
                    maxPassengers = Integer.parseInt(maxPassengersStr);
                    break; // Break out of the loop if a valid value is entered
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(this, "Invalid input. Please enter a valid integer for Max Passengers.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        int maxSpeed;
        while (true) {
            String maxSpeedStr = JOptionPane.showInputDialog(this, "Enter Max Speed: ");
            if (maxSpeedStr == null || maxSpeedStr.isEmpty()) {
                int optionResult = JOptionPane.showConfirmDialog(this, "Please enter a value for Max Speed.", "Missing Field", JOptionPane.OK_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE);
                if (optionResult == JOptionPane.CANCEL_OPTION) {
                    return null; // User clicked cancel, exit method
                }
            } else {
                try {
                    maxSpeed = Integer.parseInt(maxSpeedStr);
                    break; // Break out of the loop if a valid integer value is entered
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(this, "Invalid input. Max Speed should be an integer.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        String flag;
        while (true) {
            flag = JOptionPane.showInputDialog(this, "Enter Flag: ");
            if (flag == null || flag.isEmpty()) {
                int optionResult = JOptionPane.showConfirmDialog(this, "Please enter a value for Flag.", "Missing Field", JOptionPane.OK_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE);
                if (optionResult == JOptionPane.CANCEL_OPTION) {
                    return null; // User clicked cancel, exit method
                }
            } else if (!flag.matches("[a-zA-Z]+")) {
                JOptionPane.showMessageDialog(this, "Invalid input. Flag should only contain letters.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
            } else {
                break; // Break out of the loop if a valid value is entered
            }
        }
        float avFuel;
        while (true) {
            String avFuelStr = JOptionPane.showInputDialog(this, "Enter Average Fuel: ");
            if (avFuelStr == null || avFuelStr.isEmpty()) {
                int optionResult = JOptionPane.showConfirmDialog(this, "Please enter a value for Average Fuel.", "Missing Field", JOptionPane.OK_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE);
                if (optionResult == JOptionPane.CANCEL_OPTION) {
                    return null; // User clicked cancel, exit method
                }
            } else {
                try {
                    avFuel = Float.parseFloat(avFuelStr);
                    break; // Break out of the loop if a valid float value is entered
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(this, "Invalid input. Average Fuel should be a floating-point number.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        float avLife;
        while (true) {
            String avLifeStr = JOptionPane.showInputDialog(this, "Enter Average Life: ");
            if (avLifeStr == null || avLifeStr.isEmpty()) {
                int optionResult = JOptionPane.showConfirmDialog(this, "Please enter a value for Average Life.", "Missing Field", JOptionPane.OK_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE);
                if (optionResult == JOptionPane.CANCEL_OPTION) {
                    return null; // User clicked cancel, exit method
                }
            } else {
                try {
                    avLife = Float.parseFloat(avLifeStr);
                    break; // Break out of the loop if a valid float value is entered
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(this, "Invalid input. Average Life should be a floating-point number.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        switch (option) {
            case "Blue":
                img = new ImageIcon("Pictures\\CruiseShip1.png");
                break;
            case "White":
                img = new ImageIcon("Pictures\\CruiseShip2.png");
                break;
        }
        CruiseShip cruiseShip = (CruiseShip) vehicleFactory.create("CruiseShip", model, maxSpeed,maxPassengers,img);
        cruiseShip.setFlag(flag);
        cruiseShip.setAverageFuel(avFuel);
        cruiseShip.setAverageLife(avLife);
        return cruiseShip;
    }

    /**
     * Creates a ElectricBicycle object based on user input.
     * @return The created ElectricBicycle object or null if the user cancels the operation.
     */
    private ElectricBicycle createElectricBicycle() {
        String[] color = new String[]{"Gray", "Red", "White"};
        ImageIcon img = getImageFromUser();
        String option = "";
        if (img == null){
            option = (String)JOptionPane.showInputDialog(this, "Choose the color of the ElectricBicycle: ", "color", 3, (Icon)null, color, color[0]);
        }
        String model;
        while (true) {
            model = JOptionPane.showInputDialog(this, "Enter Model: ");
            if (model == null || model.isEmpty()) {
                int optionResult = JOptionPane.showConfirmDialog(this, "Please enter a value for Model.", "Missing Field", JOptionPane.OK_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE);
                if (optionResult == JOptionPane.CANCEL_OPTION) {
                    return null; // User clicked cancel, exit method
                }
            } else if (!model.matches("[a-zA-Z]+")) {
                JOptionPane.showMessageDialog(this, "Invalid input. Model should only contain letters.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
            } else {
                break; // Break out of the loop if a valid value is entered
            }
        }
        int maxPassengers;
        while (true) {
            String maxPassengersStr = JOptionPane.showInputDialog(this, "Enter Max Passengers: ");
            if (maxPassengersStr == null || maxPassengersStr.isEmpty()) {
                int optionResult = JOptionPane.showConfirmDialog(this, "Please enter a value for Max Passengers.", "Missing Field", JOptionPane.OK_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE);
                if (optionResult == JOptionPane.CANCEL_OPTION) {
                    return null; // User clicked cancel, exit method
                }
            } else {
                try {
                    maxPassengers = Integer.parseInt(maxPassengersStr);
                    break; // Break out of the loop if a valid value is entered
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(this, "Invalid input. Please enter a valid integer for Max Passengers.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        int maxSpeed;
        while (true) {
            String maxSpeedStr = JOptionPane.showInputDialog(this, "Enter Max Speed: ");
            if (maxSpeedStr == null || maxSpeedStr.isEmpty()) {
                int optionResult = JOptionPane.showConfirmDialog(this, "Please enter a value for Max Speed.", "Missing Field", JOptionPane.OK_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE);
                if (optionResult == JOptionPane.CANCEL_OPTION) {
                    return null; // User clicked cancel, exit method
                }
            } else {
                try {
                    maxSpeed = Integer.parseInt(maxSpeedStr);
                    break; // Break out of the loop if a valid integer value is entered
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(this, "Invalid input. Max Speed should be an integer.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        String roadType;
        while (true) {
            roadType = JOptionPane.showInputDialog(this, "Enter roadType: ");
            if (roadType == null || roadType.isEmpty()) {
                int optionResult = JOptionPane.showConfirmDialog(this, "Please enter a value for roadType.", "Missing Field", JOptionPane.OK_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE);
                if (optionResult == JOptionPane.CANCEL_OPTION) {
                    return null; // User clicked cancel, exit method
                }
            } else if (!roadType.matches("[a-zA-Z]+")) {
                JOptionPane.showMessageDialog(this, "Invalid input. roadType should only contain letters.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
            } else {
                break; // Break out of the loop if a valid value is entered
            }
        }
        float avLife;
        while (true) {
            String avLifeStr = JOptionPane.showInputDialog(this, "Enter Average Life: ");
            if (avLifeStr == null || avLifeStr.isEmpty()) {
                int optionResult = JOptionPane.showConfirmDialog(this, "Please enter a value for Average Life.", "Missing Field", JOptionPane.OK_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE);
                if (optionResult == JOptionPane.CANCEL_OPTION) {
                    return null; // User clicked cancel, exit method
                }
            } else {
                try {
                    avLife = Float.parseFloat(avLifeStr);
                    break; // Break out of the loop if a valid float value is entered
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(this, "Invalid input. Average Life should be a floating-point number.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        return switch (option) {
            case "Gray" ->
                    new ElectricBicycle(model, maxPassengers, maxSpeed, roadType, avLife, new ImageIcon("Pictures\\ElectricBicycle1.png"));
            case "Red" ->
                    new ElectricBicycle(model, maxPassengers, maxSpeed, roadType, avLife, new ImageIcon("Pictures\\ElectricBicycle2.png"));
            case "white" ->
                    new ElectricBicycle(model, maxPassengers, maxSpeed, roadType, avLife, new ImageIcon("Pictures\\ElectricBicycle3.png"));
            default -> new ElectricBicycle(model, maxPassengers, maxSpeed, roadType, avLife, img);
        };
//        switch (option) {
//            case "Grey":
//                img = new ImageIcon("Pictures\\ElectricBicycle1.png");
//                break;
//            case "Red":
//                img = new ImageIcon("Pictures\\ElectricBicycle2.png");
//                break;
//            case "White":
//                img = new ImageIcon("Pictures\\ElectricBicycle3.png");
//                break;
//        }
//        ElectricBicycle electricBicycle = (ElectricBicycle) vehicleFactory.create("ElectricBicycle", model, maxSpeed,maxPassengers,img);
//        electricBicycle.setRoadType(roadType);
//        electricBicycle.setAverageLife(avLife);
//        return electricBicycle;
    }

    /**
     * Creates a HybridPlane object based on user input.
     * @return The created HybridPlane object or null if the user cancels the operation.
     */
    private HybridPlane createHybridPlane() {
        String[] color = new String[]{"White", "Red"};
        ImageIcon img = getImageFromUser();
        String option = "";
        if (img == null){
            option = (String)JOptionPane.showInputDialog(this, "Choose the color of the HybridPlane: ", "color", 3, (Icon)null, color, color[0]);
        }
        String model;
        while (true) {
            model = JOptionPane.showInputDialog(this, "Enter Model: ");
            if (model == null || model.isEmpty()) {
                int optionResult = JOptionPane.showConfirmDialog(this, "Please enter a value for Model.", "Missing Field", JOptionPane.OK_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE);
                if (optionResult == JOptionPane.CANCEL_OPTION) {
                    return null; // User clicked cancel, exit method
                }
            } else if (!model.matches("[a-zA-Z]+")) {
                JOptionPane.showMessageDialog(this, "Invalid input. Model should only contain letters.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
            } else {
                break; // Break out of the loop if a valid value is entered
            }
        }
        int maxPassengers;
        while (true) {
            String maxPassengersStr = JOptionPane.showInputDialog(this, "Enter Max Passengers: ");
            if (maxPassengersStr == null || maxPassengersStr.isEmpty()) {
                int optionResult = JOptionPane.showConfirmDialog(this, "Please enter a value for Max Passengers.", "Missing Field", JOptionPane.OK_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE);
                if (optionResult == JOptionPane.CANCEL_OPTION) {
                    return null; // User clicked cancel, exit method
                }
            } else {
                try {
                    maxPassengers = Integer.parseInt(maxPassengersStr);
                    break; // Break out of the loop if a valid value is entered
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(this, "Invalid input. Please enter a valid integer for Max Passengers.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        int maxSpeed;
        while (true) {
            String maxSpeedStr = JOptionPane.showInputDialog(this, "Enter Max Speed: ");
            if (maxSpeedStr == null || maxSpeedStr.isEmpty()) {
                int optionResult = JOptionPane.showConfirmDialog(this, "Please enter a value for Max Speed.", "Missing Field", JOptionPane.OK_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE);
                if (optionResult == JOptionPane.CANCEL_OPTION) {
                    return null; // User clicked cancel, exit method
                }
            } else {
                try {
                    maxSpeed = Integer.parseInt(maxSpeedStr);
                    break; // Break out of the loop if a valid integer value is entered
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(this, "Invalid input. Max Speed should be an integer.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        int wheels;
        while (true) {
            String wheelsStr = JOptionPane.showInputDialog(this, "Enter Wheels: ");
            if (wheelsStr == null || wheelsStr.isEmpty()) {
                int optionResult = JOptionPane.showConfirmDialog(this, "Please enter a value for Wheels.", "Missing Field", JOptionPane.OK_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE);
                if (optionResult == JOptionPane.CANCEL_OPTION) {
                    return null; // User clicked cancel, exit method
                }
            } else {
                try {
                    wheels = Integer.parseInt(wheelsStr);
                    break; // Break out of the loop if a valid integer value is entered
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(this, "Invalid input. Wheels should be an integer.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        String flag;
        while (true) {
            flag = JOptionPane.showInputDialog(this, "Enter Flag: ");
            if (flag == null || flag.isEmpty()) {
                int optionResult = JOptionPane.showConfirmDialog(this, "Please enter a value for Flag.", "Missing Field", JOptionPane.OK_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE);
                if (optionResult == JOptionPane.CANCEL_OPTION) {
                    return null; // User clicked cancel, exit method
                }
            } else if (!flag.matches("[a-zA-Z]+")) {
                JOptionPane.showMessageDialog(this, "Invalid input. Flag should only contain letters.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
            } else {
                break; // Break out of the loop if a valid value is entered
            }
        }
        boolean witheWind = this.windDirection();
        float avFuel;
        while (true) {
            String avFuelStr = JOptionPane.showInputDialog(this, "Enter Average Fuel: ");
            if (avFuelStr == null || avFuelStr.isEmpty()) {
                int optionResult = JOptionPane.showConfirmDialog(this, "Please enter a value for Average Fuel.", "Missing Field", JOptionPane.OK_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE);
                if (optionResult == JOptionPane.CANCEL_OPTION) {
                    return null; // User clicked cancel, exit method
                }
            } else {
                try {
                    avFuel = Float.parseFloat(avFuelStr);
                    break; // Break out of the loop if a valid float value is entered
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(this, "Invalid input. Average Fuel should be a floating-point number.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        float avLife;
        while (true) {
            String avLifeStr = JOptionPane.showInputDialog(this, "Enter Average Life ");
            if (avLifeStr == null || avLifeStr.isEmpty()) {
                int optionResult = JOptionPane.showConfirmDialog(this, "Please enter a value for Average Life.", "Missing Field", JOptionPane.OK_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE);
                if (optionResult == JOptionPane.CANCEL_OPTION) {
                    return null; // User clicked cancel, exit method
                }
            } else {
                try {
                    avLife = Float.parseFloat(avLifeStr);
                    break; // Break out of the loop if a valid float value is entered
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(this, "Invalid input. Average Life should be a floating-point number.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        switch (option) {
            case "White":
                img = new ImageIcon("Pictures\\HybridPlane1.png");
                break;
            case "Red":
                img = new ImageIcon("Pictures\\HybridPlane2.png");
                break;
        }
        HybridPlane hybridPlane = (HybridPlane) vehicleFactory.create("HybridPlane", model, maxSpeed,maxPassengers,img);
        hybridPlane.setWheels(wheels);
        hybridPlane.setFlag(flag);
        hybridPlane.setWithWind(witheWind);
        hybridPlane.setAverageFuel(avFuel);
        hybridPlane.setAverageLife(avLife);
        return hybridPlane;
    }

    /**
     * Adds a new vehicle to the existing array of vehicles.
     * @param vehicle The existing array of vehicles.
     * @param tmpVehicle The new vehicle to be added.
     * @return The updated array of vehicles.
     */
//    public static Vehicle[] addVehicle(Vehicle[] vehicle, Vehicle tmpVehicle) {
//        Vehicle[] newVehicle;
//        if (vehicle != null) {
//            newVehicle = new Vehicle[vehicle.length + 1];
//
//            System.arraycopy(vehicle, 0, newVehicle, 0, vehicle.length);
//
//            newVehicle[vehicle.length] = tmpVehicle;
//            System.out.println("new2: " + Arrays.toString(newVehicle));
//            System.out.println("Added vehicle: " + tmpVehicle);
//        } else {
//            newVehicle = new Vehicle[1];
//            newVehicle[0] = tmpVehicle;
//            System.out.println("new: " + Arrays.toString(newVehicle));
//            System.out.println("Added vehicle: " + tmpVehicle);
//        }
//        return newVehicle;
//    }

    /**
     * Handles the action events triggered by buttons.
     * @param e The action event object.
     */
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == ArrJButton[0]) {
            Jeep jeep = this.createJeep();
            if (jeep != null) {
                //vehicles = addVehicle(vehicles, jeep);
                addVehicle(jeep);
            } else {
                JOptionPane.showMessageDialog((Component)null, "The details of the vehicle are incorrect, Try Again!", "Error", 0);
            }
        } else if (e.getSource() == ArrJButton[1]) {
            Frigate frigate = this.createFrigate();
            if (frigate != null) {
                addVehicle(frigate);
            } else {
                JOptionPane.showMessageDialog((Component)null, "The details of the vehicle are incorrect, Try Again!", "Error", 0);
            }
        } else if (e.getSource() == ArrJButton[2]) {
            Spy spy = this.createSpy();
            if (spy != null) {
                addVehicle(spy);
            } else {
                JOptionPane.showMessageDialog((Component)null, "The details of the vehicle are incorrect, Try Again!", "Error", 0);
            }
        } else if (e.getSource() == ArrJButton[3]) {
            Game game = this.createGame();
            if (game != null) {
                addVehicle(game);
                System.out.println("ve:");
                for (Vehicle vehicle : MenuFrame.vehicles) {
                    System.out.println(vehicle);
                }
            } else {
                JOptionPane.showMessageDialog((Component)null, "The details of the vehicle are incorrect, Try Again!", "Error", 0);
            }
        } else if (e.getSource() == ArrJButton[4]) {
            Amphibious amphibious = this.createAmphibious();
            if (amphibious != null) {
                addVehicle(amphibious);
            } else {
                JOptionPane.showMessageDialog((Component)null, "The details of the vehicle are incorrect, Try Again!", "Error", 0);
            }
        } else if (e.getSource() == ArrJButton[5]) {
            Bicycle bicycle = this.createBicycle();
            if (bicycle != null) {
                addVehicle(bicycle);
            } else {
                JOptionPane.showMessageDialog((Component)null, "The details of the vehicle are incorrect, Try Again!", "Error", 0);
            }
        } else if (e.getSource() == ArrJButton[6]) {
            CruiseShip cruiseShip = this.createCruiseShip();
            if (cruiseShip != null) {
                addVehicle(cruiseShip);
            } else {
                JOptionPane.showMessageDialog((Component)null, "The details of the vehicle are incorrect, Try Again!", "Error", 0);
            }
        } else if (e.getSource() == ArrJButton[7]) {
            ElectricBicycle electricBicycle = this.createElectricBicycle();
            if (electricBicycle != null) {
                addVehicle(electricBicycle);
            } else {
                JOptionPane.showMessageDialog((Component) null, "The details of the vehicle are incorrect, Try Again!", "Error", 0);
            }
        } else if (e.getSource() == ArrJButton[8]) {
            HybridPlane hybridPlane = this.createHybridPlane();
            if (hybridPlane != null) {
                addVehicle(hybridPlane);;
            } else {
                JOptionPane.showMessageDialog((Component) null, "The details of the vehicle are incorrect, Try Again!", "Error", 0);
            }
        } else if (e.getSource() == ArrJButton[9]) {
            if (MenuFrame.vehicles != null) {
                this.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(this, "You can not return to main until you add at least one vehicle!", "Error", 0);
            }
        }
        //mainWindow.initImagePanel();
        this.setVisible(false);
    }
}