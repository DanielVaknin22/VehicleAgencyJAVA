package Graphic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import java.util.ArrayList;

public class MainFrame extends JFrame implements ActionListener {
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
        for (int i = 0; i < ArrJButton.length; i++) {
            panel.add(ArrJButton[i]);
            ArrJButton[i].addActionListener(new JeepPanel());
        }
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



        public void initPanelsVehicle()
    {
        arrayVehiclePanels.add(new JeepPanel());
        /*
        arrayVehiclePanels.add(new FrigatePanel());
        arrayVehiclePanels.add(new SpyPlanePanel());
        arrayVehiclePanels.add(new GamePlanePanel());
        arrayVehiclePanels.add(new AmphibiousPanel());
        arrayVehiclePanels.add(new BicyclePanel());
        arrayVehiclePanels.add(new CruiseShipPanel());
         */
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

    /**public static ImageIcon resizeImage(ImageIcon img) {
        Image im = img.getImage();
        Image tmp = im.getScaledInstance(5, 1, Image.SCALE_SMOOTH);
        return new ImageIcon(tmp);
        Image im = img.getImage();
        Image scaledIm = im.getScaledInstance(10, 10, Image.SCALE_SMOOTH);
        return new ImageIcon(scaledIm);
    }**/


    public void SetImageAndPlaceText() {
        String[] sourceImg = {"Pictures\\JeepIcon.png", "Pictures\\FrigateIcon.png", "Pictures\\SpyIcon.png", "Pictures\\JeepIcon.png"
                , "Pictures\\JeepIcon.png", "Pictures\\JeepIcon.png", "Pictures\\JeepIcon.png", "Pictures\\JeepIcon.png"};
        for (int i = 0; i < ArrJButton.length; i++) {
            ImageIcon icon = new ImageIcon(sourceImg[i]);
            Image im = icon.getImage();
            Image scaledIm = im.getScaledInstance(100, 85, Image.SCALE_SMOOTH);
            ImageIcon img = new ImageIcon(scaledIm);
            ArrJButton[i].setIcon(img);
            ArrJButton[i].setHorizontalTextPosition(JButton.CENTER);
            ArrJButton[i].setVerticalTextPosition(JButton.TOP);
            ArrJButton[i].setBackground(new Color(212, 230, 253));
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        for (int i = 0; i < ArrJButton.length; i++) {
            if (e.getSource() == ArrJButton[i]) {
                VehiclePanel department = arrayVehiclePanels.get(i);
                JFrame departmentFrame = new JFrame(department.getEqualName());
                departmentFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                departmentFrame.setBounds(0, 0, 600, 700);
                departmentFrame.setLocationRelativeTo(null);
                departmentFrame.getContentPane().add(department.PanelComponent());
                departmentFrame.setVisible(true);
                // You can perform any additional actions or logic here
            }
        }
    }
}

