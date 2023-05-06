package Graphic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class JeepPanel extends JPanel implements VehiclePanel {
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

         //init picture:
         picture = new JLabel();
         picture.setBounds(255, 0, 320, 380);

         //resize array image and set img
         for (int i = 0; i < img.length - 1; i++)
             img[i] = resizeImage(img[i]);

         //
         for (int i = 0; i < 4; i++) {
             imgButton[i].addActionListener((ActionListener) this);
             defaultColor = imgButton[i].getBackground();
             imgButton[i].setIcon(img[i]);
         }
     }






    public static ImageIcon resizeImage(ImageIcon img)
    {
        Image im = img.getImage();
        Image tmp =  im.getScaledInstance(320, 380, Image.SCALE_REPLICATE);
        img = new ImageIcon(tmp);
        return img;
    }


    public void arrangeText()
    {
        int tmp = 10;
        for(int i =0;i<field.size();i++)
        {
            field.get(i).setBounds(0 , tmp , 130, 25);
            text.get(i).setBounds(130 , tmp , 100, 25);
            this.add(field.get(i));
            this.add(text.get(i));
            tmp+=30;
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


    public void actionPerformed(ActionEvent e) {

    }
}
