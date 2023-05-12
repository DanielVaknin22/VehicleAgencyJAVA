package Graphic;

import vehicle.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateVehicle extends JDialog implements ActionListener {
    private static JButton[] ArrJButton = new JButton[8];
    private static Vehicle[] vehicles;

    public CreateVehicle(JFrame window, Vehicle[] vehicle) {
        super(window, "Create Vehicle", true);
        vehicles = vehicle;
        JPanel createPanel = new JPanel();
        createPanel.setLayout(null);
        this.InitButtons();
        createPanel.setBounds(15, 0, 600, 300);
        JLabel Choose = new JLabel("Choose type of car");
        Choose.setFont(new Font(Choose.getName(),Font.BOLD, 30));
        Choose.setBounds(135, -20, 400, 150);
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
        this.add(createPanel);
        this.setVisible(true);
    }
    

    public Vehicle[] getVehicles(){
        return vehicles;
    }
    public void InitButtons() {
        String[] nameArray = new String[]{"Jeep", "Frigate", "Spy", "Game", "Amphibious", "Bicycle", "CruiseShip", "Menu"};
        int x = 85, y = 100;

        for(int i = 0; i < ArrJButton.length; ++i) {
            ArrJButton[i] = new JButton(nameArray[i]);
            if (i == ArrJButton.length / 2) {
                y = 210;
                x = 85;
            }

            ArrJButton[i].setBounds(x, y, 105, 100);
            x += 110;
        }
    }

    public void SetImageAndPlaceText() {
        String[] sourceImg = new String[]{"Pictures\\JeepIcon.png", "Pictures\\FrigateIcon.png", "Pictures\\SpyIcon.png", "Pictures\\GameIcon.png", "Pictures\\AmphibiousIcon.png", "Pictures\\BicycleIcon.png", "Pictures\\CruiseShipIcon.png", "Pictures\\MenuIcon.png"};
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


    private Jeep createJeep() {
        String[] color = new String[]{"Grey", "Red", "White", "Blue"};
        String option = (String)JOptionPane.showInputDialog(this, "Choose the color of the Jeep: ", "color", 3, (Icon)null, color, color[0]);
        String model = JOptionPane.showInputDialog(this, "Enter Model: ");
        int maxSpeed = Integer.parseInt(JOptionPane.showInputDialog(this, "Enter Max Speed: "));
        float avFuel = Float.parseFloat(JOptionPane.showInputDialog(this, "Enter Average Fuel: "));
        float avLife = Float.parseFloat(JOptionPane.showInputDialog(this, "Enter Average Life: "));
        return switch (option) {
            case "Grey" -> new Jeep(model, maxSpeed, avFuel, avLife, new ImageIcon("Pictures\\jeep1.png"));
            case "Red" -> new Jeep(model, maxSpeed, avFuel, avLife, new ImageIcon("Pictures\\jeep2.png"));
            case "White" -> new Jeep(model, maxSpeed, avFuel, avLife, new ImageIcon("Pictures\\jeep3.png"));
            case "Blue" -> new Jeep(model, maxSpeed, avFuel, avLife, new ImageIcon("Pictures\\jeep4.png"));
            default -> null;
        };
    }

    private Frigate createFrigate() {
        String[] color = new String[]{"Grey", "White", "Green"};
        String option = (String)JOptionPane.showInputDialog(this, "Choose the color of the Frigate: ", "color", 3, (Icon)null, color, color[0]);
        String model = JOptionPane.showInputDialog(this, "Enter Model: ");
        int maxPassengers = Integer.parseInt(JOptionPane.showInputDialog(this, "Enter Max Passengers: "));
        int maxSpeed = Integer.parseInt(JOptionPane.showInputDialog(this, "Enter Max Speed: "));
        boolean witheWind = this.windDirection();
        return switch (option) {
            case "Grey" ->
                    new Frigate(model, maxPassengers, maxSpeed, witheWind, new ImageIcon("Pictures\\Frigate2.png"));
            case "White" ->
                    new Frigate(model, maxPassengers, maxSpeed, witheWind, new ImageIcon("Pictures\\Frigate1.png"));
            case "Green" ->
                    new Frigate(model, maxPassengers, maxSpeed, witheWind, new ImageIcon("Pictures\\Frigate3.png"));
            default -> null;
        };
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

    private Game createGame() {
        String[] color = new String[]{"Blue", "Red", "Green", "Grey"};
        return switch ((String) JOptionPane.showInputDialog(this, "Choose the color of the Game: ", "color", 3, (Icon) null, color, color[0])) {
            case "Blue" -> new Game(new ImageIcon("Pictures\\Game1.png"));
            case "Red" -> new Game(new ImageIcon("Pictures\\Game2.png"));
            case "Green" -> new Game(new ImageIcon("Pictures\\Game3.png"));
            case "Grey" -> new Game(new ImageIcon("Pictures\\Game4.png"));
            default -> null;
        };
    }

    private Spy createSpy() {
        String[] color = new String[]{"Black", "White"};
        String option = (String)JOptionPane.showInputDialog(this, "Choose the color of the Spy: ", "color", 3, (Icon)null, color, color[0]);
        String power = JOptionPane.showInputDialog(this, "Enter Power: ");
        return switch (option) {
            case "Black" -> new Spy(power, new ImageIcon("Pictures\\Spy1.png"));
            case "White" -> new Spy(power, new ImageIcon("Pictures\\Spy2.png"));
            default -> null;
        };
    }

    //צריך להוסיף תמונות של זה ולשנות את הקוד בהתאם
    private Amphibious createAmphibious() {
        String[] color = new String[]{"Yellow", "Black", "Red", "Military"};
        String option = (String)JOptionPane.showInputDialog(this, "Choose the color of the Amphibious: ", "color", 3, (Icon)null, color, color[0]);
        String model = JOptionPane.showInputDialog(this, "Enter Model: ");
        int maxPassengers = Integer.parseInt(JOptionPane.showInputDialog(this, "Enter Max Passengers: "));
        int maxSpeed = Integer.parseInt(JOptionPane.showInputDialog(this, "Enter Max Speed: "));
        int wheels = Integer.parseInt(JOptionPane.showInputDialog(this, "Enter Wheels: "));
        String flag = JOptionPane.showInputDialog(this, "Enter Flag: ");
        boolean witheWind = this.windDirection();
        float avFuel = Float.parseFloat(JOptionPane.showInputDialog(this, "Enter Average Fuel: "));
        float avLife = Float.parseFloat(JOptionPane.showInputDialog(this, "Enter Average Life: "));
        return switch (option) {
            case "Yellow" ->
                    new Amphibious(model, maxPassengers, maxSpeed, wheels, flag, witheWind, avFuel, avLife, new ImageIcon("Pictures\\amphibious1.png"));
            case "Black" ->
                    new Amphibious(model, maxPassengers, maxSpeed, wheels, flag, witheWind, avFuel, avLife, new ImageIcon("Pictures\\amphibious2.png"));
            case "Red" ->
                    new Amphibious(model, maxPassengers, maxSpeed, wheels, flag, witheWind, avFuel, avLife, new ImageIcon("Pictures\\amphibious3.png"));
            case "Military" ->
                    new Amphibious(model, maxPassengers, maxSpeed, wheels, flag, witheWind, avFuel, avLife, new ImageIcon("Pictures\\amphibious4.png"));
            default -> null;
        };
    }

    private Bicycle createBicycle() {
        String[] color = new String[]{"Red", "Blue", "Purple", "Black"};
        String option = (String)JOptionPane.showInputDialog(this, "Choose the color of the Bicycle: ", "color", 3, (Icon)null, color, color[0]);
        String model = JOptionPane.showInputDialog(this, "Enter Model: ");
        int maxPassengers = Integer.parseInt(JOptionPane.showInputDialog(this, "Enter Max Passengers: "));
        int maxSpeed = Integer.parseInt(JOptionPane.showInputDialog(this, "Enter Max Speed: "));
        String roadType = JOptionPane.showInputDialog(this, "Enter Road Type: ");
        return switch (option) {
            case "Red" ->
                    new Bicycle(model, maxPassengers, maxSpeed, roadType, new ImageIcon("Pictures\\Bicycle1.png"));
            case "Blue" ->
                    new Bicycle(model, maxPassengers, maxSpeed, roadType, new ImageIcon("Pictures\\Bicycle2.png"));
            case "Purple" ->
                    new Bicycle(model, maxPassengers, maxSpeed, roadType, new ImageIcon("Pictures\\Bicycle3.png"));
            case "Black" ->
                    new Bicycle(model, maxPassengers, maxSpeed, roadType, new ImageIcon("Pictures\\Bicycle4.png"));
            default -> null;
        };
    }

    private CruiseShip createCruiseShip() {
        String[] color = new String[]{"Blue", "White"};
        String option = (String)JOptionPane.showInputDialog(this, "Choose the color of the Cruise Ship: ", "color", 3, (Icon)null, color, color[0]);
        String model = JOptionPane.showInputDialog(this, "Enter Model: ");
        int maxPassengers = Integer.parseInt(JOptionPane.showInputDialog(this, "Enter Max Passengers: "));
        int maxSpeed = Integer.parseInt(JOptionPane.showInputDialog(this, "Enter Max Speed: "));
        String flag = JOptionPane.showInputDialog(this, "Enter Flag: ");
        float avFuel = Float.parseFloat(JOptionPane.showInputDialog(this, "Enter Average Fuel: "));
        float avLife = Float.parseFloat(JOptionPane.showInputDialog(this, "Enter Average Life: "));
        return switch (option) {
            case "Blue" ->
                    new CruiseShip(model, maxPassengers, maxSpeed, flag, avFuel, avLife, new ImageIcon("Pictures\\CruiseShip1.png"));
            case "White" ->
                    new CruiseShip(model, maxPassengers, maxSpeed, flag, avFuel, avLife, new ImageIcon("Pictures\\CruiseShip2.png"));
            default -> null;
        };
    }

    public static Vehicle[] addVehicle(Vehicle[] vehicle, Vehicle tmpVehicle) {
        Vehicle[] newVehicle;
        if (vehicle != null) {
            newVehicle = new Vehicle[vehicle.length + 1];

            System.arraycopy(vehicle, 0, newVehicle, 0, vehicle.length);

            newVehicle[vehicle.length] = tmpVehicle;
        } else {
            newVehicle = new Vehicle[1];
            newVehicle[0] = tmpVehicle;
        }
        return newVehicle;
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == ArrJButton[0]) {
            Jeep jeep = this.createJeep();
            if (jeep != null) {
                vehicles = addVehicle(vehicles, jeep);
            } else {
                JOptionPane.showMessageDialog((Component)null, "The details of the vehicle are incorrect, Try Again!", "Error", 0);
            }
        } else if (e.getSource() == ArrJButton[1]) {
            Frigate frigate = this.createFrigate();
            if (frigate != null) {
                vehicles = addVehicle(vehicles, frigate);
            } else {
                JOptionPane.showMessageDialog((Component)null, "The details of the vehicle are incorrect, Try Again!", "Error", 0);
            }
        } else if (e.getSource() == ArrJButton[2]) {
            Spy spy = this.createSpy();
            if (spy != null) {
                vehicles = addVehicle(vehicles, spy);
            } else {
                JOptionPane.showMessageDialog((Component)null, "The details of the vehicle are incorrect, Try Again!", "Error", 0);
            }
        } else if (e.getSource() == ArrJButton[3]) {
            Game game = this.createGame();
            if (game != null) {
                vehicles = addVehicle(vehicles, game);
            } else {
                JOptionPane.showMessageDialog((Component)null, "The details of the vehicle are incorrect, Try Again!", "Error", 0);
            }
        } else if (e.getSource() == ArrJButton[4]) {
            Amphibious amphibious = this.createAmphibious();
            if (amphibious != null) {
                vehicles = addVehicle(vehicles, amphibious);
            } else {
                JOptionPane.showMessageDialog((Component)null, "The details of the vehicle are incorrect, Try Again!", "Error", 0);
            }
        } else if (e.getSource() == ArrJButton[5]) {
            Bicycle bicycle = this.createBicycle();
            if (bicycle != null) {
                vehicles = addVehicle(vehicles, bicycle);
            } else {
                JOptionPane.showMessageDialog((Component)null, "The details of the vehicle are incorrect, Try Again!", "Error", 0);
            }
        } else if (e.getSource() == ArrJButton[6]) {
            CruiseShip cruiseShip = this.createCruiseShip();
            if (cruiseShip != null) {
                vehicles = addVehicle(vehicles, cruiseShip);
            } else {
                JOptionPane.showMessageDialog((Component)null, "The details of the vehicle are incorrect, Try Again!", "Error", 0);
            }
        } else if (e.getSource() == ArrJButton[7]) {
            if (vehicles != null) {
                this.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(this, "You can not return to main until you add at least one vehicle!", "Error", 0);
            }
        }
    }


}
