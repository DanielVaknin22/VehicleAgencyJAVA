package Graphic;

import vehicle.Vehicle;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class sleepBuy implements Runnable {
    private Vehicle vehicle;
    private Thread bThread;
    private buyPanel buy;
    private JDialog dialog;

    public sleepBuy(buyPanel buyP, Vehicle vehicle){
        this.vehicle = vehicle;
        this.buy = buyP;
        bThread = new Thread(this);
        bThread.start();
    }

    public void showMessage(String message) {
        dialog = new JDialog();
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setSize(200, 100);
        dialog.setLocationRelativeTo(null);

        JLabel label = new JLabel(message);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        dialog.add(label);

        Timer timer = new Timer(5000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dialog.dispose();
            }
        });
        timer.setRepeats(false);
        timer.start();

        dialog.setVisible(true);
    }

    @Override
    public void run() {
        vehicle.startBuying();
        try {
            Random rand = new Random();
            int randomNum;
            randomNum = 5000 + rand.nextInt(10000 - 5000);
            this.showMessage("Waiting time - " + randomNum/1000 + " second");
            bThread.sleep(randomNum);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }
        int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to buy this vehicle?", "Message", JOptionPane.YES_NO_OPTION);
        if (option == JOptionPane.YES_OPTION) {
            vehicle.endBuying();
            MenuFrame.vehicles.remove(vehicle);
            buy.update();
            buy.repaint();
        }
        vehicle.endBuying();
    }
}
