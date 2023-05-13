package Graphic;

import vehicle.Vehicle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestDrive extends JDialog implements ActionListener {
    private static Vehicle[] vehicles;
    private static JButton[] ArrJButton;
    private static JButton returnToMenu = new JButton("Return the menu");
    private int index;
    private int km;

    /**
     * Creates a dialog window for test driving vehicles.
     *
     * @param window  The parent JFrame window.
     * @param vehicle The array of available vehicles.
     */
    public TestDrive(JFrame window, Vehicle[] vehicle) {
        super(window, "Test Drive", true);
        vehicles = vehicle;
        this.setBounds(0, 30, 600, 730);
        this.setLocationRelativeTo(null);//put the windows in the center
        JPanel testDrivePanel = new JPanel();
        this.setLayout(null);
        testDrivePanel.setBounds(0, 30, 600, 500);
        ArrJButton = new JButton[vehicle.length];
        for (int i = 0; i < vehicles.length; i++) {
            ImageIcon imageIcon = new ImageIcon(vehicles[i].getImg().getImage());
            Image im = imageIcon.getImage();
            Image scaledIm = im.getScaledInstance(120, 100, 4);
            ArrJButton[i] = new JButton(new ImageIcon(scaledIm));
            ArrJButton[i].setPreferredSize(new Dimension(120, 100));
        }

        for (int i = 0; i < ArrJButton.length; i++) {
            testDrivePanel.add(ArrJButton[i]);
            ArrJButton[i].addActionListener(this);

        }
        returnToMenu.addActionListener(this);
        returnToMenu.setSize(150, 30);
        returnToMenu.setBounds(220, 600, returnToMenu.getWidth(), returnToMenu.getHeight());
        this.add(returnToMenu);
        this.add(testDrivePanel);
        this.setVisible(true);
    }

    /**
     * @return The index of the selected vehicle.
     */
    public int getIndex() {
        return index;
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
                        this.setVisible(false);
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(this, "Invalid input! Please enter a valid integer for KM.");
                    }
                }
            }
            if (e.getSource() == returnToMenu) {
                int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to return the menu?", "message", JOptionPane.YES_NO_OPTION);
                if (option == JOptionPane.YES_OPTION) {
                    this.setVisible(false);
                }
            }
        }
    }
}
