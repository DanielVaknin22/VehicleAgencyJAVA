package Graphic;

import vehicle.IMarine;
import vehicle.Vehicle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MenuFrame extends JFrame implements ActionListener, MouseListener {
    private static JButton[] ArrJButton = new JButton[6];
    private static JButton[] ArrImg;
    private JPanel ImgPanel;
    private static Vehicle[] vehicles;
    private static Popup popup;


    public MenuFrame() {
        CreateVehicle createVehicle = new CreateVehicle(this, vehicles);
        vehicles = createVehicle.getVehicles();
        this.setTitle("Menu");
        setBounds(0, 30, 600, 730);
        setLocationRelativeTo(null);//put the windows in the center
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//close the windows when click X
        this.InitButtons();
        this.setVisible(true);
        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(null);
        ImgPanel = new JPanel();
        menuPanel.setBounds(15, 0, 600, 350);
        ImgPanel.setBounds(15, 0, 600, 700);
        for (JButton jButton : ArrJButton) {
            menuPanel.add(jButton);
            jButton.addActionListener(this);
        }
        ArrImg = new JButton[vehicles.length];
        int x = 60, y = 350;
        for (int i = 0; i < vehicles.length; i++) {
            ImageIcon imageIcon = new ImageIcon(vehicles[i].getImg().getImage());
            Image im = imageIcon.getImage();
            Image scaledIm = im.getScaledInstance(150, 120, 4);
            ArrImg[i] = new JButton(new ImageIcon(scaledIm));
            //ArrImg[i].setPreferredSize(new Dimension(150, 120));
            if (i == ArrImg.length / 2)//to get new line
            {
                y = 475;
                x = 60;
            }
            ArrImg[i].setBounds(x, y, 150, 120);
            x += 155;

        }
        initImgPanel(ArrImg);
        this.add(menuPanel);
        this.add(ImgPanel);
    }


    private void initImgPanel(JButton[] arrB) {
        ImgPanel.removeAll();
        for (int i = 0; i < vehicles.length; i++) {
            ImgPanel.add(arrB[i]);
            ImgPanel.revalidate();
            ImgPanel.repaint();
            ArrImg[i].addMouseListener(this);
        }
    }

    public void InitButtons() {
        String[] nameArray = {"Add Vehicle", "Buy Vehicle", "Test Drive", "Set Flag", "Reset KM", "Exit"};
        int x = 110, y = 100;
        for (int i = 0; i < ArrJButton.length; i++) {
            ArrJButton[i] = new JButton(nameArray[i]);//create new button
            if (i == ArrJButton.length / 2)//to get new line
            {
                y = 210;
                x = 110;
            }
            ArrJButton[i].setBounds(x, y, 105, 100);//resize the buttons
            x += 110;
        }
    }

    private static Vehicle[] removeVehicle(Vehicle[] vehicle, int i) {
        Vehicle[] newVehicle = new Vehicle[vehicle.length - 1];
        int k = 0;
        for (int j = 0; j < vehicle.length; j++) {
            if (j != i) {
                newVehicle[k] = vehicle[j];
                k++;
            }
        }
        return newVehicle;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (popup != null) {
            popup.hide();
        }

        JLabel[] labels = new JLabel[ArrImg.length];

        for (int i = 0; i < ArrImg.length; i++) {
            if (e.getSource() == ArrImg[i]) {
                labels[i] = new JLabel(vehicles[i].toString());
                popup = PopupFactory.getSharedInstance().getPopup(e.getComponent(), labels[i], e.getXOnScreen(), e.getYOnScreen());
                popup.show();
            }
        }
    }



    @Override
    public void mouseReleased(MouseEvent e) {
        if (popup != null) popup.hide();
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    private Vehicle[] testDrive(Vehicle[] vehicle, int i, int km) {
        vehicle[i].Move(km);
        return vehicle;
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

    public JButton[] addButton(JButton[] arrImg){
        arrImg = new JButton[vehicles.length];
        int x = 60, y = 350;
        for (int i = 0; i < vehicles.length; i++) {
            ImageIcon imageIcon = new ImageIcon(vehicles[i].getImg().getImage());
            Image im = imageIcon.getImage();
            Image scaledIm = im.getScaledInstance(100, 85, 4);
            arrImg[i] = new JButton(new ImageIcon(scaledIm));
            arrImg[i].setPreferredSize(new Dimension(100, 85));
            if (i == arrImg.length / 2)//to get new line
            {
                y = 440;
                x = 60;
            }
            arrImg[i].setBounds(x, y, 100, 85);
            x += 105;

        }
        return arrImg;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == ArrJButton[0]) {
            CreateVehicle createVehicle = new CreateVehicle(this,vehicles);
            vehicles = createVehicle.getVehicles();
            ArrImg = addButton(ArrImg);
            initImgPanel(ArrImg);
        }
        if (e.getSource() == ArrJButton[1]) {
            BuyVehicle buyVehicle = new BuyVehicle(this, vehicles);
            int k = buyVehicle.getIndex();
            if (k > -1 && k < vehicles.length - 1) {
                vehicles = removeVehicle(vehicles, k);
                ArrImg = removeButton(ArrImg, k);
                initImgPanel(ArrImg);
                this.revalidate();
                this.repaint();
            }
        }
        if (e.getSource() == ArrJButton[2]) {
            TestDrive testDrive = new TestDrive(this, vehicles);
            int j = testDrive.getIndex();
            if (j > -1 && j < vehicles.length - 1) {
                int k = testDrive.getKm();
                vehicles = testDrive(vehicles, j, k);
            }
        }
        if (e.getSource() == ArrJButton[3]) {
            ChangeFlag changeFlag = new ChangeFlag(this, vehicles);
            int k = changeFlag.getIndex();
            String[] img = {"Israel", "USA", "Germany", "Somalia", "Italy", "Pirath", "Greece"};
            if (k > -1 && k < vehicles.length - 1) {
                for (Vehicle vehicle : vehicles) {
                    if (vehicle instanceof IMarine) {
                        ((IMarine) vehicle).setFlag(img[k]);
                    }
                }
            }
        }
        if(e.getSource() == ArrJButton[4]){
            int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to reset the distance traveled?", "message", JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.YES_OPTION) {
                for (Vehicle vehicle : vehicles) {
                    vehicle.setKm(0);
                }
            }
        }
        if (e.getSource() == ArrJButton[5]){
            int option = JOptionPane.showConfirmDialog(null, "Are you sure?", "message", JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.YES_OPTION) {
                JOptionPane.showMessageDialog(null, "Bye Bye!");
                System.exit(0);
            }
        }
    }
}