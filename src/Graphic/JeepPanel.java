package Graphic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.Component;

public class JeepPanel extends JPanel implements VehiclePanel, ActionListener {
    private static JButton[] imgButton = new JButton[4];
    private ArrayList<JLabel> field = new ArrayList<JLabel>();
    private ArrayList<JTextField> text = new ArrayList<JTextField>();

    public JeepPanel() {
        this.setLayout(null);
        this.setBounds(15, 280, 600, 700);
        field.add(new JLabel("Model: "));
        text.add(new JTextField());
        field.add(new JLabel("Max Speed:"));
        text.add(new JTextField());
        field.add(new JLabel("Average Fuel: "));
        text.add(new JTextField());
        field.add(new JLabel("Average Life: "));
        text.add(new JTextField());
        arrangeText();
        InitButtons();
        SetImageAndPlaceText();
    }

    public void InitButtons() {
        String[] jeepArray = {"Jeep 1", "Jeep 2", "Jeep 3", "Jeep 4"};
        int x = 60, y = 100;
        for (int i = 0; i < imgButton.length; i++) {
            imgButton[i] = new JButton(jeepArray[i]); // Create new button
            if (i == imgButton.length / 2) {
                y = 210;
                x = 60;
            }
            imgButton[i].setBounds(x, y, 105, 100); // Resize the buttons
            x += 110;
            this.add(imgButton[i]); // Add the button to the panel
        }
    }

    // Set the button icon and text position
    public void SetImageAndPlaceText() {
        String[] imageFilePath = {"Pictures/jeep1.png", "Pictures/jeep2.png", "Pictures/jeep3.png", "Pictures/jeep4.png"};

        for (int i = 0; i < imgButton.length; i++) {
            ImageIcon icon = new ImageIcon(imageFilePath[i]);
            Image im = icon.getImage();
            Image scaledIm = im.getScaledInstance(100, 85, Image.SCALE_SMOOTH);
            ImageIcon img = new ImageIcon(scaledIm);
            imgButton[i].setIcon(img);
            imgButton[i].setHorizontalTextPosition(JButton.CENTER);
            imgButton[i].setVerticalTextPosition(JButton.TOP);
            imgButton[i].setBackground(new Color(212, 230, 253));
        }
    }

    public ImageIcon resizeImage(ImageIcon img) {
        Image im = img.getImage();
        Image tmp = im.getScaledInstance(320, 380, Image.SCALE_REPLICATE);
        img = new ImageIcon(tmp);
        return img;
    }

    public void arrangeText() {
        int tmp = 10;
        for (int i = 0; i < field.size(); i++) {
            field.get(i).setBounds(0, tmp, 130, 25);
            text.get(i).setBounds(130, tmp, 100, 25);
            this.add(field.get(i));
            this.add(text.get(i));
            tmp += 30;
        }
    }

    @Override
    public boolean addVehicleToAgency() {
        return false;
    }

    @Override
    public Component PanelComponent() {
        return null;
    }

    @Override
    public void resetValues() {
        for (int i = 0; i < text.size(); i++)
            text.get(i).setText("");
    }

    @Override
    public void setImg(String nameImg) {

    }

    @Override
    public String getEqualName() {
        return "Jeep";
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(null, imgButton);

    }
}

