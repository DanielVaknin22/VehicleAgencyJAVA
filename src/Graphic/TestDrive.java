package Graphic;

import vehicle.Vehicle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestDrive extends JDialog implements ActionListener {
    private static Vehicle[] vehicles;
    private static JButton[] ArrJButton;
    private int index;
    private int km;

    public TestDrive(JFrame window,Vehicle[] vehicle){
        super(window,"Test Drive", true);
        vehicles = vehicle;
        this.setBounds(0, 30, 600, 730);
        this.setLocationRelativeTo(null);//put the windows in the center
        JPanel buyPanel = new JPanel(new GridLayout(vehicle.length, 1));
        buyPanel.setBounds(15, 0, 600, 500);
        ArrJButton = new JButton[vehicle.length];

        for (int i = 0; i < vehicles.length; i++) {
            ImageIcon imageIcon = new ImageIcon(vehicles[i].getImg().getImage());
            Image im = imageIcon.getImage();
            Image scaledIm = im.getScaledInstance(100, 85, 4);
            ArrJButton[i] = new JButton(new ImageIcon(scaledIm));
            ArrJButton[i].setBackground(new Color(212, 230, 253));
            ArrJButton[i].setPreferredSize(new Dimension(100,85));
        }

        for (int i = 0; i < vehicles.length; i++) {
            buyPanel.add(ArrJButton[i]);
            ArrJButton[i].addActionListener(this);

        }

        this.add(buyPanel);
        this.setVisible(true);
    }

    public int getIndex() {
        return index;
    }

    public int getKm() {
        return km;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        index = -1;
        for (int i = 0; i < vehicles.length; i++) {
            if(e.getSource() == ArrJButton[i]){
                index = i;
                km = Integer.parseInt(JOptionPane.showInputDialog(this, "Enter the KM of your vehicle: "));

            }
        }
        this.setVisible(false);
    }
}
