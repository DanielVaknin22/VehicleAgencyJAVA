package Graphic;

import vehicle.Vehicle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class buyPanel extends JPanel implements Runnable, ActionListener {
    private MenuFrame mainWindow;
    private ArrayList<JButton> vehicleButtons;
    private int index;
    private boolean firstTime;

    public buyPanel(){
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

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < vehicleButtons.size(); i++) {
            if (e.getSource() == vehicleButtons.get(i)) {
                int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to buy this vehicle?", "Message", JOptionPane.YES_NO_OPTION);
                if (option == JOptionPane.YES_OPTION) {
                    index = i;
                    //update();
                    JButton removedButton = vehicleButtons.remove(i); // Remove the corresponding button from the vehicleButtons list
                    this.remove(removedButton); // Remove the button from the buyPanel
                    MenuFrame.vehicles.remove(index);
                    //mainWindow.initImagePanel();
                    repaint();
                    break;
                }
            }
        }
    }
}
