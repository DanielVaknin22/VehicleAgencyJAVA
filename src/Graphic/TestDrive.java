package Graphic;

import vehicle.Vehicle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class TestDrive extends JFrame implements ActionListener {
    private static JButton[] ArrJButton;
    private static JButton returnToMenu = new JButton("Return to Menu");
    private int index;
    private int km;

    /**
     * Creates a frame for test driving vehicles.
     * @param vehicle The array of available vehicles.
     */
    public TestDrive(ArrayList<Vehicle> vehicles) {
        //vehicles = vehicle;
        this.setTitle("Test Drive");
        this.setBounds(0, 30, 600, 730);
        this.setLocationRelativeTo(null); // put the window in the center
        JPanel testDrivePanel = new JPanel();
        this.setLayout(null);
        testDrivePanel.setBounds(0, 30, 600, 500);
        ArrJButton = new JButton[vehicles.size()];
        for (int i = 0; i < vehicles.size(); i++) {
            ImageIcon imageIcon = new ImageIcon(vehicles.get(i).getImg().getImage());
            Image im = imageIcon.getImage();
            Image scaledIm = im.getScaledInstance(120, 100, 4);
            ArrJButton[i] = new JButton(new ImageIcon(scaledIm));
            ArrJButton[i].setPreferredSize(new Dimension(120, 100));
        }

        for (JButton jButton : ArrJButton) {
            testDrivePanel.add(jButton);
            jButton.addActionListener(this);
        }

        returnToMenu.addActionListener(this);
        returnToMenu.setSize(150, 30);
        returnToMenu.setBounds(220, 600, returnToMenu.getWidth(), returnToMenu.getHeight());
        this.add(returnToMenu);
        this.add(testDrivePanel);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Close only this window
        this.setVisible(true);
    }

    /**
     * @return The index of the selected vehicle.
     */
    public int getIndex(ArrayList<Vehicle> vehicles) {
        return index;
    }


    /**
     * Performs a test drive on a vehicle.
     * @param index The index of the vehicle to test drive.
     * @param km    The number of kilometers to drive.
     */
    private void testDrive(int index, int km) {
        MenuFrame.vehicles.get(index).Move(km);
    }

    /**
     * @return The number of kilometers driven.
     */
    public int getKm() {
        return km;
    }

    /**
     * Handles the action events triggered by buttons.
     *
     * @param e The action event object.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        index = -1;
        for (int i = 0; i < ArrJButton.length; i++) {
            if (e.getSource() == ArrJButton[i]) {
                boolean validInput = false;
                while (!validInput) {
                    String input = JOptionPane.showInputDialog(this, "Enter the KM of your vehicle: ");
                    try {
                        km = Integer.parseInt(input);
                        validInput = true;
                        index = i;
                        //this.setVisible(false);
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(this, "Invalid input! Please enter a valid integer for KM.");
                    }
                }
                testDrive(index,km);
            }
        }
        if (e.getSource() == returnToMenu) {
            int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to return to the menu?", "message", JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.YES_OPTION) {
                this.setVisible(false);
            }
        }
    }
}
