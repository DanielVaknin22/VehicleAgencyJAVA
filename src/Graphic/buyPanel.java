package Graphic;

import vehicle.IAir;
import vehicle.ILand;
import vehicle.IMarine;
import vehicle.Vehicle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class buyPanel extends JPanel implements Runnable, ActionListener {
    private ArrayList<JButton> vehicleButtons;
    private int actionType;
    private int km;
    private Thread t_buy;
    private boolean firstTime;

    public buyPanel(int actionType){
        this.actionType = actionType;
        this.firstTime = true;
        t_buy = new Thread(this);
        t_buy.start();
    }
    public void removeButton(Vehicle vehicle){
        vehicleButtons.remove(vehicle);
    }

    @Override
    public void run() {
        int size = MenuFrame.vehicles.size();
        System.out.println("r1:" + size);
        while (true) {
            System.out.println("r2:" + MenuFrame.vehicles.size());
            if (MenuFrame.vehicles.size() != size || firstTime ) {
                this.removeAll();
                firstTime = false;
                size = MenuFrame.vehicles.size();
                vehicleButtons = new ArrayList<>();
                int x = 15, y = 400;
                for (int i = 0; i < MenuFrame.vehicles.size(); i++) {
                    ImageIcon imageIcon = new ImageIcon(MenuFrame.vehicles.get(i).getImg().getImage());
                    Image image = imageIcon.getImage();
                    Image scaledImage = image.getScaledInstance(150, 120, Image.SCALE_SMOOTH);
                    JButton button = new JButton(new ImageIcon(scaledImage));
                    button.setPreferredSize(new Dimension(150, 120));
                    if (i == MenuFrame.vehicles.size() / 2) {
                        y = 525;
                        x = 15;
                    }
                    button.setBounds(x, y, 150, 120);
                    x += 155;
                    button.addActionListener(this);
                    this.add(button);
                    vehicleButtons.add(button);
                }
                this.revalidate();
                this.repaint();
            }
        }
    }

    private void testDrive(int index, int km) {
        MenuFrame.vehicles.get(index).Move(km);
    }

    public void update() {
        Thread t = new Thread(() -> {
            try {
                synchronized (MenuFrame.vehicles) {
                    Random rand = new Random();
                    int randomNum;
                    randomNum = rand.nextInt((8000 - 3000) + 3000);
                    Loading loading = new Loading("Database is loading");
                    Thread.sleep(randomNum);
                    Thread.sleep(700);
                    loading.terminate();
                }
            } catch (InterruptedException e) {
                JOptionPane.showMessageDialog(null, "Error");
            }
        });
        t.start();
    }

    private boolean checkBeforeTest(Vehicle vehicle){
        for (int i = 0; i < MenuFrame.vehicles.size(); i++) {
            if (MenuFrame.vehicles.get(i).getTest() && ((MenuFrame.vehicles.get(i) instanceof IMarine && vehicle instanceof IMarine)
                    || (MenuFrame.vehicles.get(i) instanceof IAir && vehicle instanceof IAir) ||
                    (MenuFrame.vehicles.get(i) instanceof ILand && vehicle instanceof ILand))) {
                JOptionPane.showMessageDialog(null, "This kind of vehicle is on test drive.");
                return true;
            }
        }
        return false;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (actionType == 1) {
            for (int i = 0; i < vehicleButtons.size(); i++) {
                if (e.getSource() == vehicleButtons.get(i)) {
                    if (MenuFrame.vehicles.get(i).getTest()) {
                        JOptionPane.showMessageDialog(null, "The vehicle is on test drive.");
                        break;
                    }
                    sleepBuy s2 = new sleepBuy(this, MenuFrame.vehicles.get(i));
                        break;
                    }
                }
            }
         else if (actionType == 2) {
            for (int i = 0; i < vehicleButtons.size(); i++) {
                if (e.getSource() == vehicleButtons.get(i)) {
                    if(MenuFrame.vehicles.get(i).getBuying()){
                        JOptionPane.showMessageDialog(this, "This vehicle is in buying process.");
                        break;
                    }
                    if (checkBeforeTest(MenuFrame.vehicles.get(i))){
                        break;
                    }
                    boolean validInput = false;
                    while (!validInput) {
                        String input = JOptionPane.showInputDialog(this, "Enter the KM of your vehicle: ");
                        try {
                            km = Integer.parseInt(input);
                            validInput = true;
                            //this.setVisible(false);
                        } catch (NumberFormatException ex) {
                            JOptionPane.showMessageDialog(this, "Invalid input! Please enter a valid integer for KM.");
                        }
                    }
                    sleepCar s1 = new sleepCar(MenuFrame.vehicles.get(i), km);
                    testDrive(i, km);
                }
            }
        }
    }
}
