package Graphic;

import vehicle.IMarine;
import vehicle.Vehicle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

/**
 * Represents a frame for changing the flag of a vehicle.
 */
public class ChangeFlag extends JFrame implements ActionListener {
    private static Vehicle[] vehicles;
    private static JButton[] ArrJButton = new JButton[8];
    private int index;

    /**
     * Constructs a new ChangeFlag frame instance.
     * @param vehicles An array of vehicles to change the flag for.
     */
    public ChangeFlag(ArrayList<Vehicle> vehicles) {
        //vehicles = vehicle;
        this.setTitle("Change Flag");
        this.setBounds(0, 30, 600, 730);
        this.setLocationRelativeTo(null);//put the window in the center
        JPanel ChangeFlagPanel = new JPanel(new GridLayout(ArrJButton.length, 1));
        ChangeFlagPanel.setBounds(15, 0, 600, 500);

        String[] img = new String[]{"Pictures\\IsraelFlag.png", "Pictures\\USAFlag.png", "Pictures\\GermanyFlag.png", "Pictures\\SomaliaFlag.png", "Pictures\\ItalyFlag.png", "Pictures\\PirathFlag.png", "Pictures\\GreeceFlag.png"};

        for (int i = 0; i < ArrJButton.length - 1; i++) {
            ImageIcon imageIcon = new ImageIcon(img[i]);
            Image im = imageIcon.getImage();
            Image scaledIm = im.getScaledInstance(100, 85, 4);
            ArrJButton[i] = new JButton(new ImageIcon(scaledIm));
            ArrJButton[i].setPreferredSize(new Dimension(100, 85));
        }
        ArrJButton[7] = new JButton("Return to Menu");
        for (JButton jButton : ArrJButton) {
            ChangeFlagPanel.add(jButton);
            jButton.addActionListener(this);
        }

        this.add(ChangeFlagPanel);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Close only this window
        this.setVisible(true);
    }

    /**
     * @return The index of the selected flag.
     */
    public int getIndex(ArrayList<Vehicle> vehicles) {
        return index;
    }

    /**
     * Handles the action events from the buttons in the frame.
     *
     * @param e The ActionEvent object.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String[] flags = {"Israel", "USA", "Germany", "Somalia", "Italy", "Pirate", "Greece"};
        index = -1;
        for (int i = 0; i < ArrJButton.length - 1; i++) {
            if (e.getSource() == ArrJButton[i]) {
                int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to change flag?", "message", JOptionPane.YES_NO_OPTION);
                if (option == JOptionPane.YES_OPTION) {
                    index = i;
                    this.setVisible(false);
                }
            }
        }
        Thread t = new Thread(() -> {
            try {
                synchronized (MenuFrame.vehicles) {
                    Random rand = new Random();
                    int randomNum;
                    randomNum = 3000 + rand.nextInt((8000 - 3000) + 1);
                    Loading loading = new Loading("Updating Database...");
                    for (int i = 0; i < MenuFrame.vehicles.size(); i++) {
                        if (MenuFrame.vehicles.get(i) instanceof IMarine) {
                            ((IMarine) MenuFrame.vehicles.get(i)).setFlag(flags[index]);
                        }
                    }
                    Thread.sleep(randomNum);
                    loading.setText("Update Done!");
                    Thread.sleep(700);
                    loading.terminate();
                }
            } catch (InterruptedException d) {
                JOptionPane.showMessageDialog(null, "Error");
            }
        });
        t.start();
        if (e.getSource() == ArrJButton[7]) {
            int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to return to the menu?", "message", JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.YES_OPTION) {
                this.setVisible(false);
            }
        }
    }
}



