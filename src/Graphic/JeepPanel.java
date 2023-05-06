package Graphic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class JeepPanel extends JPanel implements VehiclePanel, ActionListener {
    private static JLabel picture;
    private Color defaultColor;
    private static JButton[] imgButton = new JButton[4];
    private static ImageIcon[] img = {new ImageIcon("...")};
    private ArrayList<JLabel> field = new ArrayList<JLabel>();
    private ArrayList<JTextField> text = new ArrayList<JTextField>();

    public JeepPanel() {
        this.setLayout(null);
        this.setBounds(15, 280, 600, 700);
        field.add(new JLabel("Model: "));
        text.add(new JTextField());
        field.add(new JLabel("Max Speed: "));
        text.add(new JTextField());
        field.add(new JLabel("Average Fuel: "));
        text.add(new JTextField());
        field.add(new JLabel("Average Life: "));
        text.add(new JTextField());

        InitButtons();
        SetImageAndPlaceText();
        arrangeText();
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
            imgButton[i].addActionListener(this); // Add ActionListener
            defaultColor = imgButton[i].getBackground();
            this.add(imgButton[i]); // Add the button to the panel
        }
    }

    // Set the button icon and text position
    public void SetImageAndPlaceText() {
        String[] imageFilePath = {"Pictures/jeep1.png", "Pictures/jeep2.png", "Pictures/jeep3.png", "Pictures/jeep4.png"};

        for (int i = 0; i < imgButton.length; i++) {
            img[i] = new ImageIcon(imageFilePath[i]);
            imgButton[i].setIcon(resizeImage(img[i]));
            imgButton[i].setHorizontalTextPosition(JButton.CENTER);
            imgButton[i].setVerticalTextPosition(JButton.TOP);
            imgButton[i].setBackground(new Color(220, 220, 250));
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

    }

    @Override
    public void setImg(String nameImg) {

    }

    @Override
    public String getEqualName() {
        return null;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < imgButton.length; i++) {
            if (e.getSource() == imgButton[i]) {
                picture.setIcon(img[i]); // Set the picture based on the clicked button
                picture.setVisible(true); // Show the picture
                this.setVisible(true); // Show the JeepPanel
                // You can perform any additional actions or logic here
            } else {
                picture.setVisible(false); // Hide the picture for other buttons
                this.setVisible(false); // Hide the JeepPanel for other buttons
            }
        }
    }
}

