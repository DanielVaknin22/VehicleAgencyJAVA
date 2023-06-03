package Graphic;

import vehicle.IMarine;
import vehicle.Vehicle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Random;

/**
 * The MenuFrame class presents a GUI for the menu of a vehicle agency.
 */
public class MenuFrame extends JFrame implements ActionListener, MouseListener {
    private JButton[] buttons;
    private paintPanel pPanel;
    static ArrayList<Vehicle> vehicles = new ArrayList<>(); // Initialize the vehicles array with an empty array
    private Popup popup;
    private CreateVehicle createVehicle;
    private JButton inventory = new JButton("Inventory");
    /**
     * Constructs a new MenuFrame instance.
     */
    public MenuFrame() {
        setTitle("Menu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 30, 730, 730);
        setLocationRelativeTo(null);

        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(null);
        menuPanel.setBounds(0, 0, 600, 220);

        String[] buttonNames = {"Add Vehicle", "Buy Vehicle", "Test Drive", "Set Flag", "Reset KM", "Exit"};
        buttons = new JButton[buttonNames.length];

        int x = 200, y = 20;
        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new JButton(buttonNames[i]);
            if (i == buttons.length / 2) {
                y = 120;
                x = 200;
            }
            buttons[i].setBounds(x, y, 105, 90);
            x += 110;
            buttons[i].addActionListener(this);
            menuPanel.add(buttons[i]);
        }
        pPanel = new paintPanel(this);
        pPanel.setBounds(0, 300, 600, 700);
        add(pPanel);
        add(menuPanel);
        inventory.addActionListener(this);
        this.add(inventory, BorderLayout.SOUTH);
        this.revalidate();
        setVisible(true);
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
     *
     * @param e The action event object.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == inventory) {
            inventory inven = new inventory(this, vehicles);
        }
        if (e.getSource() == buttons[0]) {
            if (vehicles.size() != 0) {
                System.out.println("po");
            }
            createVehicle = new CreateVehicle(this, vehicles);
            System.out.println("create:");
            System.out.println(vehicles.size());

            //initImagePanel();
        } else if (e.getSource() == buttons[1]) {
            System.out.println(vehicles.size());
            System.out.println("BUY:");
            for (Vehicle vehicle : vehicles) {
                System.out.println(vehicle);
            }
            BuyVehicle buyVehicle = new BuyVehicle(this, vehicles);
        } else if (e.getSource() == buttons[2]) {
            TestDrive testDrive = new TestDrive(vehicles);
        } else if (e.getSource() == buttons[3]) {
            ChangeFlag changeFlag = new ChangeFlag(vehicles);
        } else if (e.getSource() == buttons[4]) {
            int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to reset the distance traveled?", "Message", JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.YES_OPTION) {
                for (Vehicle vehicle : vehicles) {
                    vehicle.setKm(0);
                    update();
                }
            }
        } else if (e.getSource() == buttons[5]) {
            int option = JOptionPane.showConfirmDialog(null, "Are you sure?", "Message", JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.YES_OPTION) {
                JOptionPane.showMessageDialog(null, "Bye Bye!");
                System.exit(0);
            }
        }
    }


    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        for (int i = 0; i < vehicles.size(); i++) {
            if (e.getSource() == pPanel.getComponent(i)) {
                JButton button = (JButton) e.getSource();
                button.setToolTipText(vehicles.get(i).toString());
                break;
            }
        }
    }


    /**
     * Invoked when a mouse button has been released on a component.
     * @param e The MouseEvent generated by the release action.
     */
    @Override
    public void mouseReleased(MouseEvent e) {
        if (popup != null) {
            popup.hide();
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
