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
        System.out.println("size: " + vehicles.length);
        this.setTitle("Menu");
        setBounds(0, 30, 700, 830);
        setLocationRelativeTo(null);//put the windows in the center
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//close the windows when click X
        this.InitButtons();
        this.setVisible(true);
        JPanel menuPanel = new JPanel();
        ImgPanel = new JPanel();
        menuPanel.setBounds(15, 0, 600, 500);
        ImgPanel.setBounds(15, 400, 600, 330);
        for (int i = 0; i < ArrJButton.length; i++) {
            menuPanel.add(ArrJButton[i]);
            ArrJButton[i].addActionListener(this);
        }
        ArrImg = new JButton[vehicles.length];

        for (int i = 0; i < vehicles.length; i++) {
            ImageIcon imageIcon = new ImageIcon(vehicles[i].getImg().getImage());
            Image im = imageIcon.getImage();
            Image scaledIm = im.getScaledInstance(100, 85, 4);
            ArrImg[i] = new JButton(new ImageIcon(scaledIm));
            ArrImg[i].setBackground(new Color(212, 230, 253));
            ArrImg[i].setPreferredSize(new Dimension(100, 85));
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
        for (int i = 0; i < ArrImg.length; i++) {
            if (popup != null) popup.hide();
            JLabel label = new JLabel();
            label.setText(vehicles[i].toString());
            popup = PopupFactory.getSharedInstance().getPopup(e.getComponent(), label, e.getXOnScreen(), e.getYOnScreen());
            popup.show();
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

    private Vehicle[] testDrive(Vehicle[] vehicle, int i,int km) {
        vehicle[i].Move(km);
        return vehicle;
    }

    public Vehicle[] updateVehicle() {
        Vehicle[] newVehicle;
        if (this.vehicles != null) {
            newVehicle = new Vehicle[this.vehicles.length + 1];

            for (int i = 0; i < this.vehicles.length; ++i) {
                newVehicle[i] = this.vehicles[i];
            }
        } else {
            newVehicle = new Vehicle[1];
        }
        return newVehicle;
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
        for (int i = 0; i < vehicles.length; i++) {
            ImageIcon imageIcon = new ImageIcon(vehicles[i].getImg().getImage());
            Image im = imageIcon.getImage();
            Image scaledIm = im.getScaledInstance(100, 85, 4);
            arrImg[i] = new JButton(new ImageIcon(scaledIm));
            arrImg[i].setBackground(new Color(212, 230, 253));
            arrImg[i].setPreferredSize(new Dimension(100, 85));
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
            for (int i = 0; i < vehicles.length; i++) {
                System.out.println("m1:" + vehicles[i]);
            }
        }
        if (e.getSource() == ArrJButton[1]) {
            BuyVehicle buyVehicle = new BuyVehicle(this, vehicles);
            int k = buyVehicle.getIndex();
            vehicles = removeVehicle(vehicles, k);
            ArrImg = removeButton(ArrImg, k);
            initImgPanel(ArrImg);
            this.revalidate();
            this.repaint();
            for (int i = 0; i < vehicles.length - 1; i++) {
                System.out.println("m:" + vehicles[i]);
            }
        }
        if (e.getSource() == ArrJButton[2]) {
            TestDrive testDrive = new TestDrive(this,vehicles);
            int j = testDrive.getIndex();
            int k = testDrive.getKm();
            vehicles = testDrive(vehicles,j,k);
        }
        if (e.getSource() == ArrJButton[3]){
            ChangeFlag changeFlag = new ChangeFlag(this,vehicles);
            int k = changeFlag.getIndex();
            String[] img = {"Israel", "USA", "Germany", "Somalia", "Italy", "Pirath", "Greece"};
            for (int i = 0; i < vehicles.length; i++) {
                if(vehicles[i] instanceof IMarine){
                    ((IMarine) vehicles[i]).setFlag(img[k]);
                }
            }
        }
        if(e.getSource() == ArrJButton[4]){
            int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to reset the distance traveled?", "message", JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.YES_OPTION) {
                for (int i = 0; i < vehicles.length; i++) {
                    vehicles[i].setKm(0);
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