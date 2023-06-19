package Graphic;

import vehicle.Vehicle;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class paintPanel extends JPanel implements Runnable, MouseListener {
    private MenuFrame mainWindow;
    public paintPanel(MenuFrame main) {
        mainWindow = main;
        Thread t1 = new Thread(this);
        t1.start();
    }
    @Override
    public void run() {
        Border border = null;
        int size = MenuFrame.vehicles.size();
        System.out.println("s1:" + size);
        while(true) {
            System.out.println("s2:" + MenuFrame.vehicles.size());
            if (MenuFrame.vehicles.size() != size) {
                this.removeAll();
                size = MenuFrame.vehicles.size();
                int x = 15, y = 400;
                for (int i = 0; i < MenuFrame.vehicles.size(); i++) {

                    System.out.println("color: " + MenuFrame.vehicles.get(i).getColor());

//                for (Vehicle vehicle : MenuFrame.vehicles) {
//                    System.out.println(vehicle);
//                }
                    ImageIcon imageIcon = new ImageIcon(MenuFrame.vehicles.get(i).getImg().getImage());
                    Image image = imageIcon.getImage();
                    Image scaledImage = image.getScaledInstance(150, 120, Image.SCALE_SMOOTH);
                    JButton imageButton = new JButton(new ImageIcon(scaledImage));
                    imageButton.setPreferredSize(new Dimension(150, 120));
                    Color color1 = MenuFrame.vehicles.get(i).getColor();
                    if(color1 == Color.RED){
                        border = BorderFactory.createLineBorder(Color.RED, 5);
                    }
                    if(color1 == Color.GRAY){
                        border = BorderFactory.createLineBorder(Color.GRAY, 5);
                    }
                    if(color1 == Color.GREEN){
                        border = BorderFactory.createLineBorder(Color.GREEN, 5);
                    }
                    if(color1 == Color.MAGENTA){
                        border = BorderFactory.createLineBorder(Color.MAGENTA, 5);
                    }
                    if(color1 == Color.YELLOW){
                        border = BorderFactory.createLineBorder(Color.YELLOW, 5);
                    }
                    if(color1 == Color.BLUE){
                        border = BorderFactory.createLineBorder(Color.BLUE, 5);
                    }
                    if(color1 == Color.WHITE){
                        border = BorderFactory.createLineBorder(Color.WHITE, 5);
                    }
                    if(color1 == Color.BLACK){
                        border = BorderFactory.createLineBorder(Color.BLACK, 5);
                    }
                    imageButton.setBorder(border);
                    if (i == MenuFrame.vehicles.size() / 2) {
                        y = 525;
                        x = 15;
                    }
                    imageButton.setBounds(x, y, 150, 120);
                    x += 155;
                    imageButton.addMouseListener(this);
                    this.add(imageButton);
                }
                this.revalidate();
                this.repaint();
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
    public void mouseReleased(MouseEvent e) {

    }
    @Override
    public void mouseEntered(MouseEvent e) {
        for (int i = 0; i < MenuFrame.vehicles.size(); i++) {
            if (e.getSource() == this.getComponent(i)) {
                JButton button = (JButton) e.getSource();
                button.setToolTipText(MenuFrame.vehicles.get(i).toString());
                break;
            }
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
