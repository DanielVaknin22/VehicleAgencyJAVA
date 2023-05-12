package Graphic;

import vehicle.Vehicle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Represents a dialog for changing the flag of a vehicle.
 */
public class ChangeFlag extends JDialog implements ActionListener {
    private static Vehicle[] vehicles;
    private static JButton[] ArrJButton = new JButton[8];
    private int index;

    /**
     * Constructs a new ChangeFlag dialog instance.
     * @param window  The parent frame for the dialog.
     * @param vehicle An array of vehicles to change the flag for.
     */
    public ChangeFlag(JFrame window, Vehicle[] vehicle) {
        super(window, "Change Flag", true);
        vehicles = vehicle;
        this.setBounds(0, 30, 600, 730);
        this.setLocationRelativeTo(null);//put the windows in the center
        JPanel ChangeFlagPanel = new JPanel(new GridLayout(ArrJButton.length, 1));
        ChangeFlagPanel.setBounds(15, 0, 600, 500);

        String[] img = new String[]{"Pictures\\IsraelFlag.png", "Pictures\\USAFlag.png", "Pictures\\GermanyFlag.png", "Pictures\\SomaliaFlag.png", "Pictures\\ItalyFlag.png", "Pictures\\PirathFlag.png", "Pictures\\GreeceFlag.png"};

        for (int i = 0; i < ArrJButton.length - 1; i++) {
            ImageIcon imageIcon = new ImageIcon(img[i]);
            Image im = imageIcon.getImage();
            Image scaledIm = im.getScaledInstance(100, 85, 4);
            ArrJButton[i] = new JButton(new ImageIcon(scaledIm));
            //ArrJButton[i].setBackground(new Color(212, 230, 253));
            //ArrJButton[i].setPreferredSize(new Dimension(100,85));
        }
        ArrJButton[7] = new JButton("Return the menu");
        for (JButton jButton : ArrJButton) {
            ChangeFlagPanel.add(jButton);
            jButton.addActionListener(this);
        }

        this.add(ChangeFlagPanel);
        this.setVisible(true);
    }

    /**
     * @return The index of the selected flag.
     */
    public int getIndex() {
        return index;
    }

    /**
     * Handles the action events from the buttons in the dialog.
     * @param e The ActionEvent object.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
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
        if (e.getSource() == ArrJButton[7]) {
            int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to return the menu?", "message", JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.YES_OPTION) {
                this.setVisible(false);
            }
        }
    }
}


