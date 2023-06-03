package Graphic;

import vehicle.Vehicle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class BuyVehicle extends JFrame implements ActionListener, Runnable {
    private ArrayList<JButton> vehicleButtons;
    private JButton returnToMenu = new JButton("Return to Menu");
    private static Vehicle vehicleInBuy = null;
    private buyPanel bPanel;

    /**
     * Creates a frame for buying vehicles.
     * @param vehicles The array of available vehicles.
     */
    public BuyVehicle(MenuFrame main, ArrayList<Vehicle> vehicles) {
        Thread tBuy = new Thread(this);
        tBuy.start();
    }

    /**
     * Handles the action events triggered by buttons.
     * @param e The action event object.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == returnToMenu) {
            int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to return to the menu?", "Message", JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.YES_OPTION) {
                dispose(); // Close the frame
            }
        }
    }

    @Override
    public void run() {
        setTitle("Buy Vehicle");
        setBounds(0, 30, 730, 730);
        setLocationRelativeTo(null); // Center the window
        setLayout(null);

        //buyPanel.setLayout(null);
        bPanel = new buyPanel(1);
        bPanel.setBounds(0, 30, 600, 500);
        add(bPanel);
        returnToMenu.addActionListener(this);
        returnToMenu.setSize(150, 30);
        returnToMenu.setBounds(270, 600, returnToMenu.getWidth(), returnToMenu.getHeight());

        add(returnToMenu);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Close only this window
        this.revalidate();
        setVisible(true);
    }
}
