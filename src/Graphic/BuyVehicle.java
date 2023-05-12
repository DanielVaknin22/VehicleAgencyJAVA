package Graphic;

import vehicle.Vehicle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BuyVehicle extends JDialog implements ActionListener {
    private static Vehicle[] vehicles;
    private static JButton[] ArrJButton;
    private int index;


    public BuyVehicle(JFrame window, Vehicle[] vehicle) {
        super(window, "Buy Vehicle", true);
        vehicles = vehicle;
        this.setBounds(0, 30, 600, 730);
        this.setLocationRelativeTo(null);//put the windows in the center
        JPanel buyPanel = new JPanel(new GridLayout(vehicle.length, 1));
        buyPanel.setBounds(15, 0, 600, 500);
        ArrJButton = new JButton[vehicle.length + 1];

        for (int i = 0; i < vehicles.length; i++) {
            ImageIcon imageIcon = new ImageIcon(vehicles[i].getImg().getImage());
            Image im = imageIcon.getImage();
            Image scaledIm = im.getScaledInstance(100, 85, 4);
            ArrJButton[i] = new JButton(new ImageIcon(scaledIm));
            //ArrJButton[i].setBackground(new Color(212, 230, 253));
            //ArrJButton[i].setPreferredSize(new Dimension(100,85));
        }
        ArrJButton[vehicle.length] = new JButton("Return the menu");
        for (int i = 0; i < ArrJButton.length; i++) {
            buyPanel.add(ArrJButton[i]);
            ArrJButton[i].addActionListener(this);

        }
        this.add(buyPanel);
        this.setVisible(true);
    }

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

    public int getIndex(){
        return this.index;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        index = -1;
        for (int i = 0; i < ArrJButton.length - 1; i++) {
            if(e.getSource() == ArrJButton[i]){
                int option = JOptionPane.showConfirmDialog(null,"Are you sure you want to buy this vehicle?", "message", JOptionPane.YES_NO_OPTION);
                if(option == JOptionPane.YES_OPTION){
                    index = i;
                    ArrJButton = removeButton(ArrJButton,i);
                    this.setVisible(false);
                }
            }
        }
        if (e.getSource() == ArrJButton[ArrJButton.length - 1]) {
            int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to return the menu?", "message", JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.YES_OPTION) {
                this.setVisible(false);
            }
        }
    }
}
