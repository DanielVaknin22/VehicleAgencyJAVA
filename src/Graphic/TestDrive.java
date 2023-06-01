package Graphic;

import vehicle.Vehicle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class TestDrive extends JFrame implements ActionListener, Runnable {
    private static JButton[] ArrJButton;
    private static JButton returnToMenu = new JButton("Return to Menu");
    private int index;
    private int km;
    buyPanel testDrivePanel;

    /**
     * Creates a frame for test driving vehicles.
     * @param vehicles The array of available vehicles.
     */
    public TestDrive(ArrayList<Vehicle> vehicles) {
        //vehicles = vehicle;
        Thread t1 = new Thread(this);
        t1.start();
    }

    /**
     * Handles the action events triggered by buttons.
     *
     * @param e The action event object.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == returnToMenu) {
            int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to return to the menu?", "message", JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.YES_OPTION) {
                this.setVisible(false);
            }
        }
    }

    @Override
    public void run() {
        this.setTitle("Test Drive");
        this.setBounds(0, 30, 600, 730);
        this.setLocationRelativeTo(null); // put the window in the center
        testDrivePanel = new buyPanel(2);
        this.setLayout(null);
        testDrivePanel.setBounds(0, 30, 600, 500);

        returnToMenu.addActionListener(this);
        returnToMenu.setSize(150, 30);
        returnToMenu.setBounds(220, 600, returnToMenu.getWidth(), returnToMenu.getHeight());
        this.add(returnToMenu);
        this.add(testDrivePanel);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Close only this window
        this.setVisible(true);
    }
}
