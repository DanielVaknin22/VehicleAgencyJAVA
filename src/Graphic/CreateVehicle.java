package Graphic;

import vehicle.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class CreateVehicle extends JDialog implements ActionListener {
    private static JButton[] ArrJButton = new JButton[8];
    //private static JButton[] imgButton = new JButton[4];
    private static Vehicle[] vehicles;

    public CreateVehicle(JFrame window, Vehicle[] vehicle) {
        super(window,"Create Vehicle",true);
        vehicles = vehicle;
        this.InitButtons();
        JPanel createPanel = new JPanel();
        createPanel.setBounds(15, 0, 600, 500);
        for(int i = 0; i < ArrJButton.length; ++i) {
            createPanel.add(ArrJButton[i]);
            ArrJButton[i].addActionListener(this);
        }
        JLabel Welcome = new JLabel("Welcome to the Vehicle Agency!");
        Welcome.setFont(new Font(Welcome.getName(), 1, 25));
        Welcome.setBounds(100, -58, 400, 150);
        createPanel.add(Welcome);
        JLabel Choose = new JLabel("Choose type of car");
        Choose.setFont(new Font(Welcome.getName(), 1, 20));
        Choose.setBounds(175, -20, 400, 150);
        createPanel.add(Choose);
        this.add(createPanel);
        this.setBounds(0, 30, 600, 730);
        this.setLocationRelativeTo(null);
        this.SetImageAndPlaceText();
        this.setVisible(true);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                // Create and display the second window
                //MenuFrame menu = new MenuFrame();
                setVisible(true);
            }
        });

    }
    public Vehicle[] getVehicles(){
        return vehicles;
    }
    public void InitButtons() {
        String[] nameArray = new String[]{"Jeep", "Frigate", "Spy", "Game", "Amphibious", "Bicycle", "CruiseShip", "Menu"};
        int x = 60;
        int y = 100;

        for(int i = 0; i < ArrJButton.length; ++i) {
            ArrJButton[i] = new JButton(nameArray[i]);
            if (i == ArrJButton.length / 2) {
                y = 210;
                x = 60;
            }

            ArrJButton[i].setBounds(x, y, 105, 100);
            x += 110;
        }
    }

    public void SetImageAndPlaceText() {
        String[] sourceImg = new String[]{"Pictures\\JeepIcon.png", "Pictures\\FrigateIcon.png", "Pictures\\SpyIcon.png", "Pictures\\JeepIcon.png", "Pictures\\JeepIcon.png", "Pictures\\JeepIcon.png", "Pictures\\JeepIcon.png", "Pictures\\JeepIcon.png"};
        for(int i = 0; i < ArrJButton.length; ++i) {
            ImageIcon icon = new ImageIcon(sourceImg[i]);
            Image im = icon.getImage();
            Image scaledIm = im.getScaledInstance(100, 85, 4);
            ImageIcon img = new ImageIcon(scaledIm);
            ArrJButton[i].setIcon(img);
            ArrJButton[i].setHorizontalTextPosition(0);
            ArrJButton[i].setVerticalTextPosition(1);
            ArrJButton[i].setBackground(new Color(212, 230, 253));
        }

    }

    public Vehicle[] updateVehicle() {
        Vehicle[] newVehicle;
        if (this.vehicles != null) {
            newVehicle = new Vehicle[this.vehicles.length + 1];

            for(int i = 0; i < this.vehicles.length; ++i) {
                newVehicle[i] = this.vehicles[i];
            }
        } else {
            newVehicle = new Vehicle[1];
        }
        return newVehicle;
    }


    private Jeep createJeep() {
        String[] color = new String[]{"Grey", "Red", "White", "Blue"};
        String option = (String)JOptionPane.showInputDialog(this, "Choose the color of the Jeep: ", "color", 3, (Icon)null, color, color[0]);
        String model = JOptionPane.showInputDialog(this, "Enter Model: ");
        int maxSpeed = Integer.parseInt(JOptionPane.showInputDialog(this, "Enter Max Speed: "));
        float avFuel = Float.parseFloat(JOptionPane.showInputDialog(this, "Enter Average Fuel: "));
        float avLife = Float.parseFloat(JOptionPane.showInputDialog(this, "Enter Average Life: "));
        switch (option) {
            case "Grey":
                return new Jeep(model, maxSpeed, avFuel, avLife, new ImageIcon("Pictures\\jeep1.png"));
            case "Red":
                return new Jeep(model, maxSpeed, avFuel, avLife, new ImageIcon("Pictures\\jeep2.png"));
            case "White":
                return new Jeep(model, maxSpeed, avFuel, avLife, new ImageIcon("Pictures\\jeep3.png"));
            case "Blue":
                return new Jeep(model, maxSpeed, avFuel, avLife, new ImageIcon("Pictures\\jeep4.png"));
            default:
                return null;
        }
    }

    private Frigate createFrigate() {
        String[] color = new String[]{"Grey", "White"};
        String option = (String)JOptionPane.showInputDialog(this, "Choose the color of the Frigate: ", "color", 3, (Icon)null, color, color[0]);
        String model = JOptionPane.showInputDialog(this, "Enter Model: ");
        int maxPassengers = Integer.parseInt(JOptionPane.showInputDialog(this, "Enter Max Passengers: "));
        int maxSpeed = Integer.parseInt(JOptionPane.showInputDialog(this, "Enter Max Speed: "));
        boolean witheWind = this.windDirection();
        switch (option) {
            case "Grey":
                return new Frigate(model, maxPassengers, maxSpeed, witheWind, new ImageIcon("Pictures\\Frigate1.png"));
            case "White":
                return new Frigate(model, maxPassengers, maxSpeed, witheWind, new ImageIcon("Pictures\\Frigate2.png"));
            default:
                return null;
        }
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
        switch ((String)JOptionPane.showInputDialog(this, "Choose the color of the Game: ", "color", 3, (Icon)null, color, color[0])) {
            case "Blue":
                return new Game(new ImageIcon("Pictures\\Game1.png"));
            case "Red":
                return new Game(new ImageIcon("Pictures\\Game2.png"));
            case "Green":
                return new Game(new ImageIcon("Pictures\\Game3.png"));
            case "Grey":
                return new Game(new ImageIcon("Pictures\\Game4.png"));
            default:
                return null;
        }
    }

    private Spy createSpy() {
        String[] color = new String[]{"Black", "White"};
        String option = (String)JOptionPane.showInputDialog(this, "Choose the color of the Spy: ", "color", 3, (Icon)null, color, color[0]);
        String power = JOptionPane.showInputDialog(this, "Enter Power: ");
        switch (option) {
            case "Black":
                return new Spy(power, new ImageIcon("Pictures\\Spy1.png"));
            case "White":
                return new Spy(power, new ImageIcon("Pictures\\Spy2.png"));
            default:
                return null;
        }
    }

    //צריך להוסיף תמונות של זה ולשנות את הקוד בהתאם
    private Amphibious createAmphibious() {
        String[] color = new String[]{"Grey", "Red", "White", "Blue"};
        String option = (String)JOptionPane.showInputDialog(this, "Choose the color of the Amphibious: ", "color", 3, (Icon)null, color, color[0]);
        String model = JOptionPane.showInputDialog(this, "Enter Model: ");
        int maxPassengers = Integer.parseInt(JOptionPane.showInputDialog(this, "Enter Max Passengers: "));
        int maxSpeed = Integer.parseInt(JOptionPane.showInputDialog(this, "Enter Max Speed: "));
        int wheels = Integer.parseInt(JOptionPane.showInputDialog(this, "Enter Wheels: "));
        String flag = JOptionPane.showInputDialog(this, "Enter Flag: ");
        boolean witheWind = this.windDirection();
        float avFuel = Float.parseFloat(JOptionPane.showInputDialog(this, "Enter Average Fuel: "));
        float avLife = Float.parseFloat(JOptionPane.showInputDialog(this, "Enter Average Life: "));
        switch (option) {
            case "Grey":
                return new Amphibious(model, maxPassengers, maxSpeed, wheels, flag, witheWind, avFuel, avLife, new ImageIcon("Pictures\\jeep1.png"));
            case "Red":
                return new Amphibious(model, maxPassengers, maxSpeed, wheels, flag, witheWind, avFuel, avLife, new ImageIcon("Pictures\\jeep2.png"));
            case "White":
                return new Amphibious(model, maxPassengers, maxSpeed, wheels, flag, witheWind, avFuel, avLife, new ImageIcon("Pictures\\jeep3.png"));
            case "Blue":
                return new Amphibious(model, maxPassengers, maxSpeed, wheels, flag, witheWind, avFuel, avLife, new ImageIcon("Pictures\\jeep4.png"));
            default:
                return null;
        }
    }

    private Bicycle createBicycle() {
        String[] color = new String[]{"Red", "Blue", "Purple", "Black"};
        String option = (String)JOptionPane.showInputDialog(this, "Choose the color of the Bicycle: ", "color", 3, (Icon)null, color, color[0]);
        String model = JOptionPane.showInputDialog(this, "Enter Model: ");
        int maxPassengers = Integer.parseInt(JOptionPane.showInputDialog(this, "Enter Max Passengers: "));
        int maxSpeed = Integer.parseInt(JOptionPane.showInputDialog(this, "Enter Max Speed: "));
        String roadType = JOptionPane.showInputDialog(this, "Enter Road Type: ");
        switch (option) {
            case "Red":
                return new Bicycle(model, maxPassengers, maxSpeed, roadType, new ImageIcon("Pictures\\Bicycle1.png"));
            case "Blue":
                return new Bicycle(model, maxPassengers, maxSpeed, roadType, new ImageIcon("Pictures\\Bicycle2.png"));
            case "Purple":
                return new Bicycle(model, maxPassengers, maxSpeed, roadType, new ImageIcon("Pictures\\Bicycle3.png"));
            case "Black":
                return new Bicycle(model, maxPassengers, maxSpeed, roadType, new ImageIcon("Pictures\\Bicycle4.png"));
            default:
                return null;
        }
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
        switch (option) {
            case "Blue":
                return new CruiseShip(model, maxPassengers, maxSpeed, flag, avFuel, avLife, new ImageIcon("Pictures\\CruiseShip1.png"));
            case "White":
                return new CruiseShip(model, maxPassengers, maxSpeed, flag, avFuel, avLife, new ImageIcon("Pictures\\CruiseShip2.png"));
            default:
                return null;
        }
    }

    public static Vehicle[] addVehicle(Vehicle[] vehicle, Vehicle tmpVehicle) {
        Vehicle[] newVehicle;
        if (vehicle != null) {
            newVehicle = new Vehicle[vehicle.length + 1];

            for(int i = 0; i < vehicle.length; ++i) {
                newVehicle[i] = vehicle[i];
            }

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
                this.vehicles = addVehicle(this.vehicles, jeep);
            } else {
                JOptionPane.showMessageDialog((Component)null, "The details of the vehicle are incorrect, Try Again!", "Error", 0);
            }
        } else if (e.getSource() == ArrJButton[1]) {
            Frigate frigate = this.createFrigate();
            if (frigate != null) {
                this.vehicles = addVehicle(this.vehicles, frigate);
            } else {
                JOptionPane.showMessageDialog((Component)null, "The details of the vehicle are incorrect, Try Again!", "Error", 0);
            }
        } else if (e.getSource() == ArrJButton[2]) {
            Spy spy = this.createSpy();
            if (spy != null) {
                this.vehicles = addVehicle(this.vehicles, spy);
            } else {
                JOptionPane.showMessageDialog((Component)null, "The details of the vehicle are incorrect, Try Again!", "Error", 0);
            }
        } else if (e.getSource() == ArrJButton[3]) {
            Game game = this.createGame();
            if (game != null) {
                this.vehicles = addVehicle(this.vehicles, game);
            } else {
                JOptionPane.showMessageDialog((Component)null, "The details of the vehicle are incorrect, Try Again!", "Error", 0);
            }
        } else if (e.getSource() == ArrJButton[4]) {
            Amphibious amphibious = this.createAmphibious();
            if (amphibious != null) {
                this.vehicles = addVehicle(this.vehicles, amphibious);
            } else {
                JOptionPane.showMessageDialog((Component)null, "The details of the vehicle are incorrect, Try Again!", "Error", 0);
            }
        } else if (e.getSource() == ArrJButton[5]) {
            Bicycle bicycle = this.createBicycle();
            if (bicycle != null) {
                this.vehicles = addVehicle(this.vehicles, bicycle);
            } else {
                JOptionPane.showMessageDialog((Component)null, "The details of the vehicle are incorrect, Try Again!", "Error", 0);
            }
        } else if (e.getSource() == ArrJButton[6]) {
            CruiseShip cruiseShip = this.createCruiseShip();
            if (cruiseShip != null) {
                this.vehicles = addVehicle(this.vehicles, cruiseShip);
            } else {
                JOptionPane.showMessageDialog((Component)null, "The details of the vehicle are incorrect, Try Again!", "Error", 0);
            }
        } else if (e.getSource() == ArrJButton[7]) {
            if (this.vehicles != null) {
                this.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(this, "You can not return to main until you add at least one vehicle!", "Error", 0);
            }
        }
        for (int i = 0; i < vehicles.length; i++) {
            System.out.println("c:" + vehicles[i]);
        }
    }


}
