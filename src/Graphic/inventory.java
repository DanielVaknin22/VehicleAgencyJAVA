package Graphic;

import javax.swing.*;
import vehicle.Vehicle;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Random;

public class inventory extends JFrame implements ActionListener {
    private paintPanel inventoryPanel;
    private MenuFrame mainWindow;
    private JButton returnToMenu = new JButton("Return to Menu");

    public inventory(MenuFrame main, ArrayList<Vehicle> vehicles) {
        mainWindow = main;
        setTitle("inventory");
        setBounds(0, 30, 730, 730);
        setLocationRelativeTo(null); // Center the window
        setLayout(null);
        inventoryPanel = new paintPanel(mainWindow);
        inventoryPanel.setBounds(0, 30, 600, 500);
        add(inventoryPanel);

        for (int i = 0; i < vehicles.size(); i++) {
            ImageIcon imageIcon = new ImageIcon(vehicles.get(i).getImg().getImage());
            Image im = imageIcon.getImage();
            Image scaledIm = im.getScaledInstance(120, 100, Image.SCALE_SMOOTH);
            JButton button = new JButton(new ImageIcon(scaledIm));
            button.setPreferredSize(new Dimension(120, 100));
            button.addActionListener(this);
            inventoryPanel.add(button);
        }
        returnToMenu.addActionListener(this);
        returnToMenu.setSize(150, 30);
        returnToMenu.setBounds(270, 600, returnToMenu.getWidth(), returnToMenu.getHeight());

        add(returnToMenu);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Close only this window
        update();
        setVisible(true);
    }

    public void update(Vehicle vehicle) {
        Thread t = new Thread(() -> {
            try {
                synchronized (MenuFrame.vehicles) {
                    Random rand = new Random();
                    int randomNum;
                    randomNum = 3000 + rand.nextInt((8000 - 3000) + 1);
                    Loading loading = new Loading("Updating Database... Please wait");
                    MenuFrame.vehicles.remove(vehicle);
                    Thread.sleep(randomNum);
                    loading.setText("Update Done!");
                    Thread.sleep(700);
                    loading.terminate();
                }
            } catch (InterruptedException e) {
                JOptionPane.showMessageDialog(null, "Error");
            }
        });
        t.start();
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

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == returnToMenu) {
            int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to return to the menu?", "Message", JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.YES_OPTION) {
                dispose(); // Close the frame
            }
        }
    }
}
