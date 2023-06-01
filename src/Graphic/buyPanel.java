package Graphic;

import vehicle.IMarine;
import vehicle.Vehicle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class buyPanel extends JPanel implements Runnable, ActionListener {
    private MenuFrame mainWindow;
    private ArrayList<JButton> vehicleButtons;
    private int index;
    private int actionType;
    private int km;
    private boolean firstTime;

    public buyPanel(int actionType){
        this.actionType = actionType;
        this.firstTime = true;
        Thread t_buy = new Thread(this);
        t_buy.start();
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

//    private boolean checkBeforeTest(Vehicle vehicle){
//        for (int i = 0; i < MenuFrame.vehicles.size(); i++) {
//            if (MenuFrame.vehicles.get(i) instanceof IMarine) {
//                ((IMarine) MenuFrame.vehicles.get(i)).setFlag(flags[index]);
//            }
//        }
//    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (actionType == 1) {
            for (int i = 0; i < vehicleButtons.size(); i++) {
                if (e.getSource() == vehicleButtons.get(i)) {
                    try {
                        Random rand = new Random();
                        int randomNum;
                        randomNum = rand.nextInt((10000 - 5000) + 5000);
                        Thread.sleep(randomNum);
                    } catch (InterruptedException ex) {
                        throw new RuntimeException(ex);
                    }
                    int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to buy this vehicle?", "Message", JOptionPane.YES_NO_OPTION);
                    if (option == JOptionPane.YES_OPTION) {
                        //update();
                        if (MenuFrame.vehicles.get(i).getTest()) {
                            JOptionPane.showMessageDialog(null, "The vehicle is on test drive.");
                            break;
                        }
                        JButton removedButton = vehicleButtons.remove(i); // Remove the corresponding button from the vehicleButtons list
                        this.remove(removedButton); // Remove the button from the buyPanel
                        MenuFrame.vehicles.remove(i);
                        update();
                        //mainWindow.initImagePanel();
                        repaint();
                        break;
                    }
                }
            }
        } else if (actionType == 2) {
            for (int i = 0; i < vehicleButtons.size(); i++) {
                if (e.getSource() == vehicleButtons.get(i)) {
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
