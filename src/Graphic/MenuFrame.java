package Graphic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.Component;

public class MenuFrame extends JFrame implements ActionListener {

    private static JButton[] ArrJButton = new JButton[6];


    public MenuFrame(){
        JFrame frame = new JFrame("Menu");
        setTitle("Menu");
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

    public void InitButtons() {
        String[] nameArray = {"Add Vehicle", "Buy Vehicle", "Test Drive", "Change Flag", "Reset Distance", "Exit"};
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






    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == ArrJButton[0]) {

        }
    }
}