package Graphic;

import vehicle.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateVehicle extends JDialog implements ActionListener {
    private static JButton[] ArrJButton = new JButton[8];
    private static JButton[] imgButton = new JButton[4];
    private Vehicle[] vehicles;

    public CreateVehicle() {
        JFrame frame = new JFrame("Car Agency");
        setTitle("Car Agency");
        setLayout(null);
        setBounds(0, 30, 600, 730);
        setLocationRelativeTo(null);
        setLocationRelativeTo(null);//put the windows in the center
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//close the windows when click X
        frame.setVisible(true);


        InitButtons();
        SetImageAndPlaceText();

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(15, 0, 600, 500);
        for (int i = 0; i < ArrJButton.length; i++) {
            panel.add(ArrJButton[i]);
            ArrJButton[i].addActionListener(this);
        }

        JLabel Welcome = new JLabel("Welcome to the Vehicle Agency!");
        Welcome.setFont(new Font(Welcome.getName(), Font.BOLD, 25));
        Welcome.setBounds(100, -58, 400, 150);
        panel.add(Welcome);
        JLabel Choose = new JLabel("Choose type of car");
        Choose.setFont(new Font(Welcome.getName(), Font.BOLD, 20));
        Choose.setBounds(175, -20, 400, 150);
        panel.add(Choose);
        this.add(panel);
    }

    public void InitButtons() {
        String[] nameArray = {"Jeep", "Frigate", "Spy", "Game", "Amphibious", "Bicycle", "CruiseShip", "Menu"};
        int x = 60, y = 100;
        for (int i = 0; i < ArrJButton.length; i++) {
            ArrJButton[i] = new JButton(nameArray[i]);//create new button
            if (i == ArrJButton.length / 2)//to get new line
            {
                y = 210;
                x = 60;
            }
            ArrJButton[i].setBounds(x, y, 105, 100);//resize the buttons
            x += 110;
        }
    }

    public void SetImageAndPlaceText() {
        String[] sourceImg = {"Pictures\\JeepIcon.png", "Pictures\\FrigateIcon.png", "Pictures\\SpyIcon.png", "Pictures\\JeepIcon.png"
                , "Pictures\\JeepIcon.png", "Pictures\\JeepIcon.png", "Pictures\\JeepIcon.png", "Pictures\\JeepIcon.png"};
        for (int i = 0; i < ArrJButton.length; i++) {
            ImageIcon icon = new ImageIcon(sourceImg[i]);
            Image im = icon.getImage();
            Image scaledIm = im.getScaledInstance(100, 85, Image.SCALE_SMOOTH);
            ImageIcon img = new ImageIcon(scaledIm);
            ArrJButton[i].setIcon(img);
            ArrJButton[i].setHorizontalTextPosition(JButton.CENTER);
            ArrJButton[i].setVerticalTextPosition(JButton.TOP);
            ArrJButton[i].setBackground(new Color(212, 230, 253));
        }
    }


    public void SetImageVehicle(String[] imageFilePath) {
        for (int i = 0; i < imgButton.length; i++) {
            ImageIcon icon = new ImageIcon(imageFilePath[i]);
            Image im = icon.getImage();
            Image scaledIm = im.getScaledInstance(100, 85, Image.SCALE_SMOOTH);
            ImageIcon img = new ImageIcon(scaledIm);
            imgButton[i].setIcon(img);
            imgButton[i].setHorizontalTextPosition(JButton.CENTER);
            imgButton[i].setVerticalTextPosition(JButton.TOP);
            imgButton[i].setBackground(new Color(212, 230, 253));
        }
    }

    private Jeep createJeep() {
        String[] color = {"Grey", "Red", "White", "Blue"};
        String option = (String) JOptionPane.showInputDialog(this, "Choose the color of the Jeep: ", "color", JOptionPane.QUESTION_MESSAGE, null, color, color[0]);
        String model = JOptionPane.showInputDialog(this, "Enter Model: ");
        int maxSpeed = Integer.parseInt(JOptionPane.showInputDialog(this, "Enter Max Speed: "));
        float avFuel = Float.parseFloat(JOptionPane.showInputDialog(this, "Enter Average Fuel: "));
        float avLife = Float.parseFloat(JOptionPane.showInputDialog(this, "Enter Average Life: "));
        switch (option) {
            case "Grey" -> {
                return new Jeep(model, maxSpeed, avFuel, avLife, new ImageIcon("Pictures\\jeep1.png"));
            }
            case "Red" -> {
                return new Jeep(model, maxSpeed, avFuel, avLife, new ImageIcon("Pictures\\jeep2.png"));
            }
            case "White" -> {
                return new Jeep(model, maxSpeed, avFuel, avLife, new ImageIcon("Pictures\\jeep3.png"));
            }
            case "Blue" -> {
                return new Jeep(model, maxSpeed, avFuel, avLife, new ImageIcon("Pictures\\jeep4.png"));
            }
        }
        return null;
    }

    private Frigate createFrigate() {
        String[] color = {"Grey", "Red", "White", "Blue"};
        String option = (String) JOptionPane.showInputDialog(this, "Choose the color of the Frigate: ", "color", JOptionPane.QUESTION_MESSAGE, null, color, color[0]);
        String model = JOptionPane.showInputDialog(this, "Enter Model: ");
        int maxPassengers = Integer.parseInt(JOptionPane.showInputDialog(this, "Enter Max Passengers: "));
        int maxSpeed = Integer.parseInt(JOptionPane.showInputDialog(this, "Enter Max Speed: "));
        boolean witheWind = windDirection();
        switch (option) {
            case "Grey" -> {
                return new Frigate(model, maxPassengers, maxSpeed, witheWind, new ImageIcon("Pictures\\jeep1.png"));
            }
            case "Red" -> {
                return new Frigate(model, maxPassengers, maxSpeed, witheWind, new ImageIcon("Pictures\\jeep2.png"));
            }
            case "White" -> {
                return new Frigate(model, maxPassengers, maxSpeed, witheWind, new ImageIcon("Pictures\\jeep3.png"));
            }
            case "Blue" -> {
                return new Frigate(model, maxPassengers, maxSpeed, witheWind, new ImageIcon("Pictures\\jeep4.png"));
            }
        }
        return null;
    }

    private boolean windDirection() {
        JPanel wind = new JPanel();
        wind.setLayout(new BoxLayout(wind, BoxLayout.PAGE_AXIS));
        JRadioButton withWindButton = new JRadioButton("With the wind direction");
        JRadioButton againstWindButton = new JRadioButton("Against the wind direction");
        ButtonGroup windGroup = new ButtonGroup();
        windGroup.add(withWindButton);
        windGroup.add(againstWindButton);
        wind.add(withWindButton);
        wind.add(againstWindButton);
        // Show the wind direction panel and wait for user selection
        JOptionPane.showConfirmDialog(this, wind, "Please enter the wind direction:", JOptionPane.OK_CANCEL_OPTION);
        // Get the selected wind direction and create the Frigate object
        return withWindButton.isSelected();
    }

    private Game createGame() {
        String[] color = {"Grey", "Red", "White", "Blue"};
        String option = (String) JOptionPane.showInputDialog(this, "Choose the color of the Game: ", "color", JOptionPane.QUESTION_MESSAGE, null, color, color[0]);
        switch (option) {
            case "Grey" -> {
                return new Game(new ImageIcon("Pictures\\jeep1.png"));
            }
            case "Red" -> {
                return new Game(new ImageIcon("Pictures\\jeep2.png"));
            }
            case "White" -> {
                return new Game(new ImageIcon("Pictures\\jeep3.png"));
            }
            case "Blue" -> {
                return new Game(new ImageIcon("Pictures\\jeep4.png"));
            }
        }
        return null;
    }

    private Spy createSpy() {
        String[] color = {"Grey", "Red", "White", "Blue"};
        String option = (String) JOptionPane.showInputDialog(this, "Choose the color of the Spy: ", "color", JOptionPane.QUESTION_MESSAGE, null, color, color[0]);
        String power = JOptionPane.showInputDialog(this, "Enter Power: ");
        switch (option) {
            case "Grey" -> {
                return new Spy(power, new ImageIcon("Pictures\\jeep1.png"));
            }
            case "Red" -> {
                return new Spy(power, new ImageIcon("Pictures\\jeep2.png"));
            }
            case "White" -> {
                return new Spy(power, new ImageIcon("Pictures\\jeep3.png"));
            }
            case "Blue" -> {
                return new Spy(power, new ImageIcon("Pictures\\jeep4.png"));
            }
        }
        return null;
    }

    private Amphibious createAmphibius() {
        String[] color = {"Grey", "Red", "White", "Blue"};
        String option = (String) JOptionPane.showInputDialog(this, "Choose the color of the Amphibious: ", "color", JOptionPane.QUESTION_MESSAGE, null, color, color[0]);
        String model = JOptionPane.showInputDialog(this, "Enter Model: ");
        int maxPassengers = Integer.parseInt(JOptionPane.showInputDialog(this, "Enter Max Passengers: "));
        int maxSpeed = Integer.parseInt(JOptionPane.showInputDialog(this, "Enter Max Speed: "));
        int wheels = Integer.parseInt(JOptionPane.showInputDialog(this, "Enter Wheels: "));
        String flag = JOptionPane.showInputDialog(this, "Enter Flag: ");
        boolean witheWind = windDirection();
        float avFuel = Float.parseFloat(JOptionPane.showInputDialog(this, "Enter Average Fuel: "));
        float avLife = Float.parseFloat(JOptionPane.showInputDialog(this, "Enter Average Life: "));
        switch (option) {
            case "Grey" -> {
                return new Amphibious(model, maxPassengers, maxSpeed, wheels, flag, witheWind, avFuel, avLife, new ImageIcon("Pictures\\jeep1.png"));
            }
            case "Red" -> {
                return new Amphibious(model, maxPassengers, maxSpeed, wheels, flag, witheWind, avFuel, avLife, new ImageIcon("Pictures\\jeep2.png"));
            }
            case "White" -> {
                return new Amphibious(model, maxPassengers, maxSpeed, wheels, flag, witheWind, avFuel, avLife, new ImageIcon("Pictures\\jeep3.png"));
            }
            case "Blue" -> {
                return new Amphibious(model, maxPassengers, maxSpeed, wheels, flag, witheWind, avFuel, avLife, new ImageIcon("Pictures\\jeep4.png"));
            }
        }
        return null;
    }

    private Bicycle createBicycle() {
        String[] color = {"Grey", "Red", "White", "Blue"};
        String option = (String) JOptionPane.showInputDialog(this, "Choose the color of the Amphibious: ", "color", JOptionPane.QUESTION_MESSAGE, null, color, color[0]);
        String model = JOptionPane.showInputDialog(this, "Enter Model: ");
        int maxPassengers = Integer.parseInt(JOptionPane.showInputDialog(this, "Enter Max Passengers: "));
        int maxSpeed = Integer.parseInt(JOptionPane.showInputDialog(this, "Enter Max Speed: "));
        String roadType = JOptionPane.showInputDialog(this, "Enter Road Type: ");
        switch (option) {
            case "Grey" -> {
                return new Bicycle(model, maxPassengers, maxSpeed, roadType, new ImageIcon("Pictures\\jeep1.png"));
            }
            case "Red" -> {
                return new Bicycle(model, maxPassengers, maxSpeed, roadType, new ImageIcon("Pictures\\jeep2.png"));
            }
            case "White" -> {
                return new Bicycle(model, maxPassengers, maxSpeed, roadType, new ImageIcon("Pictures\\jeep3.png"));
            }
            case "Blue" -> {
                return new Bicycle(model, maxPassengers, maxSpeed, roadType, new ImageIcon("Pictures\\jeep4.png"));
            }
        }
        return null;
    }

    private CruiseShip createCruiseShip() {
        String[] color = {"Grey", "Red", "White", "Blue"};
        String option = (String) JOptionPane.showInputDialog(this, "Choose the color of the Jeep: ", "color", JOptionPane.QUESTION_MESSAGE, null, color, color[0]);
        String model = JOptionPane.showInputDialog(this, "Enter Model: ");
        int maxPassengers = Integer.parseInt(JOptionPane.showInputDialog(this, "Enter Max Passengers: "));
        int maxSpeed = Integer.parseInt(JOptionPane.showInputDialog(this, "Enter Max Speed: "));
        String flag = JOptionPane.showInputDialog(this, "Enter Flag: ");
        float avFuel = Float.parseFloat(JOptionPane.showInputDialog(this, "Enter Average Fuel: "));
        float avLife = Float.parseFloat(JOptionPane.showInputDialog(this, "Enter Average Life: "));
        switch (option) {
            case "Grey" -> {
                return new CruiseShip(model, maxPassengers, maxSpeed, flag, avFuel, avLife, new ImageIcon("Pictures\\jeep1.png"));
            }
            case "Red" -> {
                return new CruiseShip(model, maxPassengers, maxSpeed, flag, avFuel, avLife, new ImageIcon("Pictures\\jeep2.png"));
            }
            case "White" -> {
                return new CruiseShip(model, maxPassengers, maxSpeed, flag, avFuel, avLife, new ImageIcon("Pictures\\jeep3.png"));
            }
            case "Blue" -> {
                return new CruiseShip(model, maxPassengers, maxSpeed, flag, avFuel, avLife, new ImageIcon("Pictures\\jeep4.png"));
            }
        }
        return null;
    }

    public static Vehicle[] addVehicle(Vehicle[] vehicle, Vehicle tmpVehicle) {
        Vehicle[] newVehicle;
        if(vehicle !=null) {
            newVehicle = new Vehicle[vehicle.length + 1];
            for (int i = 0; i < vehicle.length; i++) {
                newVehicle[i] = vehicle[i];
            }
            newVehicle[vehicle.length] = tmpVehicle;
        }
        else{
            newVehicle = new Vehicle[1];
            newVehicle[0] = tmpVehicle;
        }
        return newVehicle;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == ArrJButton[0]) {
            // Jeep button is clicked
            Jeep jeep = createJeep();
            if (jeep != null) {
                vehicles = addVehicle(vehicles, jeep);
            } else {
                JOptionPane.showMessageDialog(null,"The details of the vehicle are incorrect, Try Again!","Error",JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == ArrJButton[1]) {
            // Frigate button is clicked
            Frigate frigate = createFrigate();
            if (frigate != null) {
                vehicles = addVehicle(vehicles, frigate);
            } else {
                JOptionPane.showMessageDialog(null,"The details of the vehicle are incorrect, Try Again!","Error",JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == ArrJButton[2]) {
            // Spy button is clicked
            Spy spy = createSpy();
            if (spy != null) {
                vehicles = addVehicle(vehicles, spy);
            } else {
                JOptionPane.showMessageDialog(null, "The details of the vehicle are incorrect, Try Again!", "Error",JOptionPane.ERROR_MESSAGE);
            }
        }
        else if (e.getSource() == ArrJButton[3]) {
            // Game button is clicked
            Game game = createGame();
            if (game != null) {
                vehicles = addVehicle(vehicles, game);
            } else {
                JOptionPane.showMessageDialog(null, "The details of the vehicle are incorrect, Try Again!", "Error",JOptionPane.ERROR_MESSAGE);
            }
        }
        else if (e.getSource() == ArrJButton[4]) {
            // Amphibious button is clicked
            Amphibious amphibious = createAmphibius();
            if (amphibious != null) {
                vehicles = addVehicle(vehicles, amphibious);
            } else {
                JOptionPane.showMessageDialog(null, "The details of the vehicle are incorrect, Try Again!", "Error",JOptionPane.ERROR_MESSAGE);
            }
        }
        else if (e.getSource() == ArrJButton[5]) {
            // Bicycle button is clicked
            Bicycle bicycle = createBicycle();
            if (bicycle != null) {
                vehicles = addVehicle(vehicles, bicycle);
            } else {
                JOptionPane.showMessageDialog(null, "The details of the vehicle are incorrect, Try Again!","Error",JOptionPane.ERROR_MESSAGE);
            }
        }
        else if (e.getSource() == ArrJButton[6]) {
            // CruiseShip button is clicked
            CruiseShip cruiseShip = createCruiseShip();
            if (cruiseShip != null) {
                vehicles = addVehicle(vehicles, cruiseShip);
            } else {
                JOptionPane.showMessageDialog(null, "The details of the vehicle are incorrect, Try Again!","Error" ,JOptionPane.ERROR_MESSAGE);
            }
        }
        else if (e.getSource() == ArrJButton[7]) {
            // Menu button is clicked
            if(vehicles != null){
                setVisible(false);
            }
            else {
                JOptionPane.showMessageDialog(this,"You can not return to main until you add at least one vehicle!","Error",JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}



