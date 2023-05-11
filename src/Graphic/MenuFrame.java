package Graphic;

import vehicle.Vehicle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuFrame extends JFrame implements ActionListener {

    private static JButton[] ArrJButton = new JButton[6];
    private static Vehicle[] vehicles;


    public MenuFrame(Vehicle[] vehicle){
        vehicles = vehicle;
        this.setTitle("Menu");
        this.setLayout((LayoutManager)null);
        setBounds(0, 30, 600, 730);
        setLocationRelativeTo(null);
        setLocationRelativeTo(null);//put the windows in the center
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//close the windows when click X
        this.InitButtons();
        this.setVisible(true);
        JPanel menuPanel = new JPanel();
        menuPanel.setLayout((LayoutManager)null);
        menuPanel.setBounds(15, 0, 600, 500);
        for (int i = 0; i < ArrJButton.length; i++) {
            menuPanel.add(ArrJButton[i]);
            ArrJButton[i].addActionListener(this);
        }
        this.add(menuPanel);

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
            if (j != i){
                newVehicle[k] = vehicle[j];
                k++;
            }
        }
        return newVehicle;
    }

    public Vehicle[] updateVehicle() {
        Vehicle[] newVehicle;
        if (this.vehicles != null) {
            newVehicle = new Vehicle[this.vehicles.length + 1];

            for(int i = 0; i < this.vehicles.length; ++i) {
                newVehicle[i] = this.vehicles[i];
            }
        } else {
            newVehicle = new Vehicle[1];
        }
        return newVehicle;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == ArrJButton[0]) {
            this.setVisible(false);
            CreateVehicle createVehicle = new CreateVehicle();
            this.vehicles = createVehicle.updateVehicle();
            for (int i = 0; i < vehicles.length; i++) {
                System.out.println("m1:" + vehicles[i]);
            }
        }
        if(e.getSource() == ArrJButton[1]){
            BuyVehicle buyVehicle = new BuyVehicle(this, this.vehicles);
            int k = buyVehicle.getIndex();
            this.vehicles = removeVehicle(vehicles,k);
            for (int i = 0; i < vehicles.length-1; i++) {
                System.out.println("m:" + vehicles[i]);
            }
        }

    }
}