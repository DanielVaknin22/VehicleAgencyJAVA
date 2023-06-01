package Graphic;

import vehicle.Vehicle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class BuyVehicle extends JFrame implements ActionListener {
    private ArrayList<JButton> vehicleButtons;
    private JButton returnToMenu = new JButton("Return to Menu");
    private int index;
    private MenuFrame mainWindow;
    private static Vehicle vehicleInBuy = null;

    private buyPanel bPanel;

    /**
     * Creates a frame for buying vehicles.
     * @param vehicles The array of available vehicles.
     */
    public BuyVehicle(MenuFrame main, ArrayList<Vehicle> vehicles) {
        mainWindow = main;
        setTitle("Buy Vehicle");
        setBounds(0, 30, 730, 730);
        setLocationRelativeTo(null); // Center the window
        setLayout(null);

        //buyPanel.setLayout(null);
        bPanel = new buyPanel(1);
        bPanel.setBounds(0, 30, 600, 500);
        add(bPanel);

//        vehicleButtons = new ArrayList<>();
//        for (Vehicle vehicle : vehicles) {
//            ImageIcon imageIcon = new ImageIcon(vehicle.getImg().getImage());
//            Image im = imageIcon.getImage();
//            Image scaledIm = im.getScaledInstance(120, 100, Image.SCALE_SMOOTH);
//            JButton button = new JButton(new ImageIcon(scaledIm));
//            button.setPreferredSize(new Dimension(120, 100));
//            button.addActionListener(this);
//            buyPanel.add(button);
//            vehicleButtons.add(button);
//        }

        returnToMenu.addActionListener(this);
        returnToMenu.setSize(150, 30);
        returnToMenu.setBounds(270, 600, returnToMenu.getWidth(), returnToMenu.getHeight());

        add(returnToMenu);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Close only this window
        this.revalidate();
        setVisible(true);
    }

    /**
     * @return The index of the selected vehicle.
     */
    public int getIndex() {
        return this.index;
    }

    public static synchronized boolean isVehicleInBuy(Vehicle vehicle) {
        return vehicleInBuy != null && vehicleInBuy.equals(vehicle);
    }

    public void update() {
        Thread t = new Thread(() -> {
            try {
                synchronized (MenuFrame.vehicles) {
                    Random rand = new Random();
                    int randomNum;
                    randomNum = 3000 + rand.nextInt((10000 - 5000) + 1);
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

    /**
     * Handles the action events triggered by buttons.
     * @param e The action event object.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
//        for (int i = 0; i < vehicleButtons.size(); i++) {
//            if (e.getSource() == vehicleButtons.get(i)) {
//                int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to buy this vehicle?", "Message", JOptionPane.YES_NO_OPTION);
//                if (option == JOptionPane.YES_OPTION) {
//                    index = i;
//                    update();
//                    JButton removedButton = vehicleButtons.remove(i); // Remove the corresponding button from the vehicleButtons list
//                    buyPanel.remove(removedButton); // Remove the button from the buyPanel
//                    MenuFrame.vehicles.remove(index);
//                    //mainWindow.initImagePanel();
//                    repaint();
//                    break;
//                }
//            }
//        }
        if (e.getSource() == returnToMenu) {
            int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to return to the menu?", "Message", JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.YES_OPTION) {
                dispose(); // Close the frame
            }
        }
    }
}
