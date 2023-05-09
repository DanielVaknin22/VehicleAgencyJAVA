package Graphic;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BuyVehicle extends JDialog implements ActionListener {
    private static JButton[] ArrJButton = new JButton[4];
    public BuyVehicle(){
        JFrame frame = new JFrame("Buy Vehicle");
        setTitle("Buy Vehicle");
        setLayout(null);
        setBounds(0, 30, 600, 730);
        setLocationRelativeTo(null);
        setLocationRelativeTo(null);//put the windows in the center
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//close the windows when click X

        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(null);
        menuPanel.setBounds(15, 0, 600, 500);
        for (int i = 0; i < ArrJButton.length; i++) {
            menuPanel.add(ArrJButton[i]);
            ArrJButton[i].addActionListener(this);
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
