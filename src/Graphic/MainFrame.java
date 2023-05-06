package Graphic;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import java.util.ArrayList;

public class MainFrame extends JFrame implements ActionListener{
    private static JButton[] ArrJButton = new JButton[8];
    static ArrayList<VehiclePanel> arrayVehiclePanels = new ArrayList<VehiclePanel>();


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
        for(int i=0; i<ArrJButton.length; i++)
            panel.add(ArrJButton[i]);
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

    public static ImageIcon resizeImage(ImageIcon img)
    {
        Image im = img.getImage();
        Image tmp = im.getScaledInstance(610, 612, Image.SCALE_REPLICATE);
        img = new ImageIcon(tmp);
        return img;
    }

    public void SetImageAndPlaceText()
    {
        String[] sourceImg = {"Pictures\\JeepIcon.png","Pictures\\JeepIcon.png","Pictures\\JeepIcon.png","Pictures\\JeepIcon.png"
        ,"Pictures\\JeepIcon.png","Pictures\\JeepIcon.png","Pictures\\JeepIcon.png","Pictures\\JeepIcon.png"};
        for(int i=0 ; i<ArrJButton.length ;i++)
        {
            ArrJButton[i].setIcon(new ImageIcon(sourceImg[i]));
            ArrJButton[i].setHorizontalTextPosition(JButton.CENTER);
            ArrJButton[i].setVerticalTextPosition(JButton.TOP);
            ArrJButton[i].setBackground(new Color(220,220,250));
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}


