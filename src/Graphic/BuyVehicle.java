package Graphic;

import vehicle.Vehicle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BuyVehicle extends JDialog implements ActionListener {
    private static Vehicle[] vehicles;
    private static JButton[] ArrJButton;
    private static JButton returnToMenu = new JButton("Return the menu");

    private int index;

    /**
     * Creates a dialog window for buying vehicles.
     * @param window  The parent JFrame window.
     * @param vehicle The array of available vehicles.
     */
    public BuyVehicle(JFrame window, Vehicle[] vehicle) {
        super(window, "Buy Vehicle", true);
        vehicles = vehicle;
        this.setBounds(0, 30, 730, 730);
        this.setLocationRelativeTo(null);//put the windows in the center
        JPanel buyPanel = new JPanel();
        this.setLayout(null);
        buyPanel.setBounds(0, 30, 600, 500);
        ArrJButton = new JButton[vehicle.length];

        for (int i = 0; i < vehicles.length; i++) {
            ImageIcon imageIcon = new ImageIcon(vehicles[i].getImg().getImage());
            Image im = imageIcon.getImage();
            Image scaledIm = im.getScaledInstance(120, 100, 4);
            ArrJButton[i] = new JButton(new ImageIcon(scaledIm));
            ArrJButton[i].setPreferredSize(new Dimension(120,100));
        }
        for (int i = 0; i < ArrJButton.length; i++) {
            buyPanel.add(ArrJButton[i]);
            ArrJButton[i].addActionListener(this);

        }
        returnToMenu.addActionListener(this);
        returnToMenu.setSize(150,30);
        returnToMenu.setBounds(270,600,returnToMenu.getWidth(),returnToMenu.getHeight());
        this.add(returnToMenu);
        this.add(buyPanel);
        this.setVisible(true);
    }

    /**
     * Removes a button from the array of buttons.
     * @param buttons The array of buttons.
     * @param i The index of the button to be removed.
     * @return The updated array of buttons.
     */
    private static JButton[] removeButton(JButton[] buttons, int i) {
        JButton[] newButtons = new JButton[buttons.length - 1];
        int k = 0;
        for (int j = 0; j < buttons.length; j++) {
            if (j != i){
                newButtons[k] = buttons[j];
                k++;
            }
        }
        return newButtons;
    }

    /**
     * @return The index of the selected vehicle.
     */
    public int getIndex(){
        return this.index;
    }

    /**
     * Handles the action events triggered by buttons.
     * @param e The action event object.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        index = -1;
        for (int i = 0; i < ArrJButton.length; i++) {
            if(e.getSource() == ArrJButton[i]){
                int option = JOptionPane.showConfirmDialog(null,"Are you sure you want to buy this vehicle?", "message", JOptionPane.YES_NO_OPTION);
                if(option == JOptionPane.YES_OPTION){
                    index = i;
                    ArrJButton = removeButton(ArrJButton,i);
                    this.setVisible(false);
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
