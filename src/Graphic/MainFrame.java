package Graphic;

import vehicle.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame implements ActionListener {
    private static JButton[] ArrJButton = new JButton[8];
    private static JButton[] imgButton = new JButton[4];
    //static ArrayList<VehiclePanel> arrayVehiclePanels = new ArrayList<VehiclePanel>();

    public MainFrame() {
        JFrame frame = new JFrame("Car Agency");
        setTitle("Car Agency");
        setLayout(null);
        setBounds(0, 30, 600, 730);
        setLocationRelativeTo(null);
        setLocationRelativeTo(null);//put the windows in the center
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//close the windows when click X

        InitButtons();
        SetImageAndPlaceText();

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(15, 0, 600, 500);
        for (int i = 0; i < ArrJButton.length; i++) {
            panel.add(ArrJButton[i]);
            //ArrJButton[i].addActionListener(new JeepPanel());
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

    /**
     * private Vehicle createVehicle() {
     * //        JButton jButton = new JButton("Add");
     * //        jButton.setBounds(15, 40, 30, 30);
     * //        this.getContentPane().add(jButton);
     * return switch (type) {
     * case "Jeep" -> createJeep();
     * case "Frigate" -> createFrigate();
     * case "Spy Glider" -> createSpyGlider();
     * case "Game Glider" -> createGameGlider();
     * case "Amphibious" -> createAmphibious();
     * case "Bicycle" -> createBicycle();
     * case "Cruise Ship" -> createCruiseShip();
     * default -> null;
     * };
     * //
     * //    }
     **/


    private Jeep createJeep() {
        String[] imageFilePath = {"Pictures/jeep1.png", "Pictures/jeep2.png", "Pictures/jeep3.png", "Pictures/jeep4.png"};
        JLabel model = new JLabel("Model: ");
        JTextField textModel = new JTextField(500);
        this.getContentPane().add(model);
        this.getContentPane().add(textModel);
        JLabel maxSpeed = new JLabel("Max Speed: ");
        JTextField textSpeed = new JTextField(500);
        this.getContentPane().add(maxSpeed);
        this.getContentPane().add(textSpeed);
        JLabel averageFuel = new JLabel("Average Fuel: ");
        JTextField textFuel = new JTextField(500);
        this.getContentPane().add(averageFuel);
        this.getContentPane().add(textFuel);
        JLabel averageLife = new JLabel("Average Life: ");
        JTextField textLife = new JTextField(500);
        this.getContentPane().add(averageLife);
        this.getContentPane().add(textLife);
        SetImageVehicle(imageFilePath);
        JButton jButton = new JButton("Add");
        return new Jeep(textModel.getText(), Integer.parseInt(textSpeed.getText()), Float.parseFloat(textFuel.getText()), Float.parseFloat(textLife.getText()));
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == ArrJButton[0]) {
            // Jeep button is clicked
            Jeep jeep = createJeep();
        } else if (e.getSource() == ArrJButton[1]) {

        } else if (e.getSource() == ArrJButton[2]) {

        }

    }
}



