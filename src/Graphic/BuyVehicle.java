package Graphic;

import vehicle.Vehicle;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BuyVehicle extends JDialog implements ActionListener {
    private static Vehicle[] vehicles;
    private static ImageIcon[] ArrImg;
    private static JButton[] ArrJButton;


    public BuyVehicle(){
        new JFrame("Buy Vehicle");
        this.setTitle("Buy Vehicle");
        this.setLayout(null);
        this.setBounds(0, 30, 600, 730);
        this.setLocationRelativeTo(null);//put the windows in the center
        this.setVisible(true);
        JPanel buyPanel = new JPanel();
        buyPanel.setLayout(null);
        buyPanel.setBounds(15, 0, 600, 500);
        for (int i = 0; i < ArrJButton.length; i++) {
            buyPanel.add(ArrJButton[i]);
            ArrJButton[i].addActionListener(this);
        }
        //SetImageAndPlaceText(ArrImg);

        this.add(buyPanel);
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
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
